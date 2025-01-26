
var projectName = '小驴西藏旅游网站的设计与实现';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的收藏',
	url: '../storeup/list.jsp'
}
]


var indexNav = [

{
	name: '景点信息',
	url: './pages/jingdianxinxi/list.jsp'
}, 
{
	name: '旅游路线',
	url: './pages/lvyouluxian/list.jsp'
}, 

{
	name: '景点资讯',
	url: './pages/news/list.jsp'
},
{
	name: '网站评论',
	url: './pages/messages/list.jsp'
}
]

var adminurl =  "http://localhost:8080/jspm8g20f/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"景点分类","menuJump":"列表","tableName":"jingdianfenlei"}],"menu":"景点分类管理"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除","查看评论"],"menu":"景点信息","menuJump":"列表","tableName":"jingdianxinxi"}],"menu":"景点信息管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除","查看评论"],"menu":"旅游路线","menuJump":"列表","tableName":"lvyouluxian"}],"menu":"旅游路线管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","修改","删除","审核"],"menu":"门票购买","menuJump":"列表","tableName":"menpiaogoumai"}],"menu":"门票购买管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除","审核"],"menu":"路线预定","menuJump":"列表","tableName":"luxianyuding"}],"menu":"路线预定管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","修改","删除","审核"],"menu":"咨询记录","menuJump":"列表","tableName":"zixunjilu"}],"menu":"咨询记录管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","修改","回复","删除"],"menu":"网站评论","tableName":"messages"}],"menu":"网站评论"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"景点资讯","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","门票购买","套餐咨询"],"menu":"景点信息列表","menuJump":"列表","tableName":"jingdianxinxi"}],"menu":"景点信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","路线预定"],"menu":"旅游路线列表","menuJump":"列表","tableName":"lvyouluxian"}],"menu":"旅游路线模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","支付"],"menu":"门票购买","menuJump":"列表","tableName":"menpiaogoumai"}],"menu":"门票购买管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看"],"menu":"路线预定","menuJump":"列表","tableName":"luxianyuding"}],"menu":"路线预定管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看"],"menu":"咨询记录","menuJump":"列表","tableName":"zixunjilu"}],"menu":"咨询记录管理"},{"child":[{"appFrontIcon":"cuIcon-favor","buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","门票购买","套餐咨询"],"menu":"景点信息列表","menuJump":"列表","tableName":"jingdianxinxi"}],"menu":"景点信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","路线预定"],"menu":"旅游路线列表","menuJump":"列表","tableName":"lvyouluxian"}],"menu":"旅游路线模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
