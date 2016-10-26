package spring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author:Just
 * @create:2016-10-24 22:31
 */
public class SpelTest {
    public static void main(String args[]){
        //创建解析器
        ExpressionParser expressionParser = new SpelExpressionParser();
        //创建表达式
        Expression expression = expressionParser.parseExpression("('hello ').concat(#end)");
        //解析上下文
        EvaluationContext context = new StandardEvaluationContext();
         context.setVariable("end","just");
        System.out.println(expression.getValue(context));

    }
}
