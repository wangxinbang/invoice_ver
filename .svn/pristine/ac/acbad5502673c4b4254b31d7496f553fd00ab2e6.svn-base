/**
 * Created by jf on 2015/9/11.
 * Modified by bear on 2016/9/7.
 */
$(function () {
    
    /** 初始化加载框 **/
    function showLoadingToast(){
    	var $loadingToast = $('#loadingToast');
        if ($loadingToast.css('display') != 'none') return;
        $loadingToast.fadeIn(100);
        setTimeout(function () {
            $loadingToast.fadeOut(100);
            window.location.href="the_answer.html";
        }, 2000);
    }
    
    /** 初始化提交按钮 **/
    function initSubmitBtn(){
    	$('#submitBtn').on('click', function(){
			showLoadingToast();
    	});
    }

    /** 页面初始化 **/
    function init(){
        initSubmitBtn();
    }
    init();
});