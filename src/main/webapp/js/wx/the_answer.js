/**
 * Created by jf on 2015/9/11.
 * Modified by bear on 2016/9/7.
 */
$(function () {
    
    /** 获取答案 **/
    function getTheAnswer(){
    	var data = {1:1};
    	$.post("answer/getAnswer.do", JSON.stringify(data), function(r){
    		$("#answerP").html(r.key);
    	});
    }

    /** 页面初始化 **/
    function init(){
        getTheAnswer();
    }
    init();
});