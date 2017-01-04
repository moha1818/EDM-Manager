
// 菜单函数
function menu(ele) {
	var $menu = $('#menu');
	var $subMenu = $('.smenu');
	// 当前一级菜单改变样式
	$menu.find('li').not($(ele)).removeClass('current');
	$(ele).addClass('current');
	
	// 显示二级菜单
	$('.submenu').show();
	var id = $(ele).attr('id').substring(2);
	if($('#c_'+id).length<1){
		$('.submenu').hide();
		return;
	}
	$('.smenu').not('#c_'+id).hide();
	$('#c_'+id).show();
}

$(function(){
	// 默认显示第一个菜单
	var $current = $('#menu li:first');
	$current.addClass('current');
	$('.submenu').show();
	var id = $current.attr('id').substring(2);
	$('#c_'+id).show();
});

//内嵌框架高度自适应
function iFrameHeight() {
	var ifm = document.getElementById("iframepage");
	var subWeb = document.frames ? document.frames["iframepage"].document
			: ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.height = subWeb.body.scrollHeight;
		ifm.width = subWeb.body.scrollWidth;
	}
}