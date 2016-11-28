/**
 * Created by Just on 2016/11/21.
 */
$(function () {
    var index = window.location.href.split("/").length-1;
    var href = window.location.href.split("/")[index];
    $(".list li a[href='"+href+"']").addClass("on");
});