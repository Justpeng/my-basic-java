/**
 * Created by sysware.com on 2016/10/2.
 */
/**
 * 根据Id获取object
 * @param e
 * @returns {Element}
 */
function getO(e){
    return document.getElementById(e);
}

/**
 * 在<canvas> 元素中用图表展示月度贷款余额，利息，资产收益
 * @param principal 贷款总额
 * @param interest 利息
 * @param monthly 月度赔付
 * @param payments 周期
 */
function chart(principal,interest,monthly,payments) {
    var graph = getO("graph");                                       //得到<canvas>标签
    graph.width=graph.width;                                         //用一种巧妙地手法清除并充值画布

    //如果出传入参数或者浏览器不支持画布，则直接返回
    if(arguments.length==0|| !graph.getContext)return;

    //获取画布元素的"context"对象，这个对象定义了一组绘画API
    var g = graph.getContext("2d");                                 //所有绘画操作都将基于这个操作
    var width = graph.width,
        height = graph.height;                                           //获得画布大小

    //将付款数字和美元数据转换为像素
    function paymentToX(n){
        return n * width / payments;
    }
    function amountToY(a){
        return height - (a * height /(monthly * payments * 1.05));
    }

    // 付款数据是一条从(0,0)到(payments,monthly*payments) 的直线
    g.moveTo(paymentToX(0),amountToY(0));                           //从左下方开始
    g.lineTo(paymentToX(payments),amountToY(monthly*payments));     //绘制右上方
    g.lineTo(paymentToX(payments),amountToY(0))                     //再至右下方
    g.closePath();                                                  //将开头和结尾相连
    g.fillStyle="#f88";                                             //亮红色
    g.fill();                                                       //填充矩形
    g.font="bold 12px sans-serif";                                  //定义一种字体
    g.fillText("Total Interest Payments",20,20);                    //将文字绘制到图例中

    // 很多资产不是线性的，很难反映至图表中
    var equity = 0;
    g.beginPath();//开始绘制新图形
    g.moveTo(paymentToX(0), amountToY(0));
    for(var p=1;p<=payments;p++){
        //计算每一笔赔付的利息
        var thisMonthsInterest = (principal-equity) * interest;
        equity += (monthly - thisMonthsInterest);//得到已还款本金（每月还本付息金额-每月利息）
        g.lineTo(paymentToX(p), amountToY(equity));//将数据绘制到画布上
    }

    g.lineTo(paymentToX(payments), amountToY(0)); //将数据线会知道X轴
    g.closePath();   //将线条结尾连接至线条开头
    g.fillStyle = "green";  //使用绿色绘制图形
    g.fill(); // 曲线下部分均填充
    g.fillText("Total Equity", 20, 35);  //文本颜色设置为绿色

    //再次循环余额显示为黑色粗线条
    var bal = principal;
    g.beginPath();
    g.moveTo(paymentToX(0), amountToY(bal));
    for(var p=1;p<=payments;p++) {
        var thisMonthsInterest = bal * interest;
        bal -= (monthly - thisMonthsInterest); //得到资产额
        g.lineTo(paymentToX(p), amountToY(bal));//将直线连接至某点
    }
    g.lineWidth=3;//将直线宽度加粗
    g.stroke();//绘制余额曲线
    g.fillStyle = "black";//黑色字体
    g.fillText("loan Balance", 20, 50);//图例文字

    // 将年度数据在X轴做标记
    g.textAlign = "center";//文字居中对齐
    var y = amountToY(0);//Y坐标设置为0
    for(var year=1;year*12<=payments;year++) {//y坐标设置为0
        var x = paymentToX(year * 12);//遍历每年
        g.fillRect(x - 0.5, y - 3, 1, 3);//开始绘制标记
        if(year==1) {
            g.fillText("Year", x, y - 5);//在坐标轴做标记
        }
        if(year%5==0 && year*12!=payments) {
            g.fillText(String(year), x, y - 5);//每五年数据
        }
    }

    g.textAlign = 'right';//将赔付额标记在右边界
    g.textBaseline = "middle";//文字垂直居中
    var ticks = [monthly * payments, principal]; //我们将要用到这两个点
    var rightEdge = paymentToX(payments);//设置X坐标
    for (var i = 0 ; i < ticks.length;i++) { //对每两个点做循环
        var y = amountToY(ticks[i]);//计算每个Y标记的坐标
        g.fillRect(rightEdge - 3, y - 0.5, 3, 1);//绘制标记
        g.fillText( String(ticks[i].toFixed(0)),rightEdge-5,y ); //绘制文本
    }

}

function showDetail(principal,interest,monthly,totalAmount) {
    var showDetail = getO("showDetail");
    var equity = 0;
    var years = parseFloat(getO("years").value);//年份
    var yearList = '<tr>' +
        '<td width="200px;">月份</td><td width="200">月供本金</td><td width="200">月供利息</td><td>剩余</td>' + +'</tr>';
    var equity = 0;//已还本金
    var lastPrincipal = 0;
    var lastAmount = totalAmount;
    for (var y = 1; y <= years; y++) {
        console.log(y);
        yearList += "<tr class='tr-head'>" + "<td colspan='4'>第" + y + "年</td></tr>";
        for (var m = 1; m <= 12; m++) {
            var am = "";
            if (m % 12 == 0) {
                am = 12;
            } else {
                am = m % 12;
            }
            lastAmount -= monthly;
            //当月月供利息
            var thisMonthsInterest = ((principal - equity) * interest);
            //当月月供本金
            var thisEquity = (monthly - thisMonthsInterest);
            equity += thisEquity;
            //剩余本金
            lastPrincipal = principal - equity;
            yearList += "<tr class='tr-body'>" +
                "<td>" + am + "月</td>" + "<td>" + thisEquity.toFixed(2) + "</td>" + "<td>" + thisMonthsInterest.toFixed(2) + "</td>" +
                "<td>" + lastAmount.toFixed(2) + "</td>"
            "</tr>";
        }
    }
    showDetail.innerHTML = yearList.trim();
}/**
 * Created by Administrator on 2016/10/22.
 */
