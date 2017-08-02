<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  

<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新增学生</title>
</head>
<body>
<!-- <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 学员登记 <span class="c-gray en">&gt;</span> 学员信息登记 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav> -->
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第一步：读取身份证</span></div>
<!-- 		<div class="row cl">
			<label class="form-label col-xs-12 col-sm-6"><span class="c-red"><h3>请在机器上放置身份证</h3></span></label>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>身份证号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="cardId" name="cardId" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="cardName" name="cardName" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="gender" name="gender" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>民族：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="nation" name="nation" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>生日：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="birthday" name="birthday" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" maxlength="20" class="input-text" value="" placeholder="" id="address" name="address" readonly="true">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="getMockData();" class="btn btn-primary radius" type="button">&nbsp;&nbsp;读取&nbsp;&nbsp;</button>
			</div>
		</div>

		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第二步：补充信息</span></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>户口性质：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="education" class="select">
					<option value="">--请选择--</option>
					<option value="50">居民户</option>
					<option value="40">外籍人士</option>
					<option value="30">台港澳人员</option>
					<option value="22">外地农业户口(外地农村)</option>
					<option value="21">本地农业户口(本地农村)</option>
					<option value="20">农业户口(农村)</option>
					<option value="12">外地非农业户口(外地城镇)</option>
					<option value="11">本地非农业户口(本地城镇)</option>
					<option value="10">非农业户口(城镇)</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>户口所在地区：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="education" class="select">
					<option value="">--请选择--</option>
					<option value="420000000000">湖北省</option>
					<option value="420100000000">湖北省武汉市</option>
					<option value="420102000000">武汉市江岸区</option>
					<option value="420102010000">武汉市江岸区第一街道</option>
					<option value="420102010100">武汉市江岸区第一街道第一社区</option>
					<option value="420103000000">武汉市江汉区</option>
					<option value="420103010000">武汉市江汉区第一街道</option>
					<option value="420103010100">武汉市江汉区第一街道第一社区</option>
					<option value="420104000000">武汉市硚口区</option>
					<option value="420105000000">武汉市汉阳区</option>
					<option value="420106000000">武汉市武昌区</option>
					<option value="420107000000">武汉市青山区</option>
					<option value="420111000000">武汉市洪山区</option>
					<option value="420112000000">武汉市东西湖区</option>
					<option value="420113000000">武汉市汉南区</option>
					<option value="420114000000">武汉市蔡甸区</option>
					<option value="420115000000">武汉市江夏区</option>
					<option value="420116000000">武汉市黄陂区</option>
					<option value="420117000000">武汉市新洲区</option>
					<option value="420140000000">武汉市东湖高新开发区</option>
					<option value="420141000000">武汉市经济开发区</option>
					<option value="420199000000">武汉市市辖区</option>
					<option value="420200000000">湖北省黄石市</option>
					<option value="420202000000">黄石市黄石港区</option>
					<option value="420203000000">黄石市西塞山区</option>
					<option value="420204000000">黄石市下陆区</option>
					<option value="420205000000">黄石市铁山区</option>
					<option value="420222000000">黄石市阳新县</option>
					<option value="420240000000">黄石市开发区</option>
					<option value="420281000000">黄石市大冶市</option>
					<option value="420299000000">黄石市市辖区</option>
					<option value="420300000000">湖北省十堰市</option>
					<option value="420302000000">十堰市茅箭区</option>
					<option value="420303000000">十堰市张湾区</option>
					<option value="420321000000">十堰市郧县</option>
					<option value="420322000000">十堰市郧西县</option>
					<option value="420323000000">十堰市竹山县</option>
					<option value="420324000000">十堰市竹溪县</option>
					<option value="420325000000">十堰市房县</option>
					<option value="420340000000">十堰市武当山特区</option>
					<option value="420381000000">十堰市丹江口市</option>
					<option value="420399000000">十堰市市辖区</option>
					<option value="420500000000">湖北省宜昌市</option>
					<option value="420502000000">宜昌市西陵区</option>
					<option value="420502010000">西陵区学院街道</option>
					<option value="420502010100">学院街道珍珠路社区</option>
					<option value="420502010200">学院街道环城东路社区</option>
					<option value="420502010300">学院街道社区</option>
					<option value="420502010400">学院街道四新路社区</option>
					<option value="420502010500">学院街道气象台社区</option>
					<option value="420502010600">学院街道环城北路社区</option>
					<option value="420502010700">学院街道北门外正街社区</option>
					<option value="420502010800">学院街道中书街社区</option>
					<option value="420502010900">学院街道星苑社区</option>
					<option value="420502011000"> 学院街道中山路社区</option>
					<option value="420502011100">学院街道东正街社区</option>
					<option value="420502011200">学院街道四方堰社区</option>
					<option value="420502011300">学院街道解放路社区</option>
					<option value="420502011400">学院街道东门外正街社区</option>
					<option value="420502011500">学院街道尚书巷社区</option>
					<option value="420502011600">学院街道翁家堰社区</option>
					<option value="420502011700">学院街道民主路社区</option>
					<option value="420502011800">学院街道廖家台社区</option>
					<option value="420502020000">西陵区云集街道</option>
					<option value="420502020100">云集街道夷陵路社区</option>
					<option value="420502020200">云集街道山庄路社区</option>
					<option value="420502020300">云集街道赵家湾社区</option>
					<option value="420502020400">云集街道广场路社区</option>
					<option value="420502020500">云集街道果园路社区</option>
					<option value="420502020600">云集街道体育场路社区</option>
					<option value="420502020700">云集街道小林园社区</option>
					<option value="420502020800">云集街道二马路社区</option>
					<option value="420503000000">宜昌市伍家岗区</option>
					<option value="420503010000">伍家岗区宝塔河街道</option>
					<option value="420503010100">宝塔河街道张家坡社区</option>
					<option value="420503010200">宝塔河街道宝联社区</option>
					<option value="420503010300">宝塔河街道韩家坝社区</option>
					<option value="420503010400">宝塔河街道合益路社区</option>
					<option value="420503020000">伍家岗区万寿桥街道</option>
					<option value="420503020100">万寿桥街道万达社区</option>
					<option value="420503030000">伍家岗区大公桥街道</option>
					<option value="420503030100">大公桥街道力行街社区</option>
					<option value="420504000000">宜昌市点军区</option>
					<option value="420505000000">宜昌市猇亭区</option>
					<option value="420506000000">宜昌市夷陵区</option>
					<option value="420525000000">宜昌市远安县</option>
					<option value="420526000000">宜昌市兴山县</option>
					<option value="420527000000">宜昌市秭归县</option>
					<option value="420528000000">宜昌市长阳土家族自治县</option>
					<option value="420529000000">宜昌市五峰土家族自治县</option>
					<option value="420540000000">宜昌市开发区</option>
					<option value="420540010000">开发区劳动保障服务所</option>
					<option value="420540010100">开发区东苑社区</option>
					<option value="420540010200">开发区南苑社区</option>
					<option value="420540010300">开发区北苑桥社区</option>
					<option value="420540010400">开发区长江社区</option>
					<option value="420581000000">宜昌市宜都市</option>
					<option value="420582000000">宜昌市当阳市</option>
					<option value="420583000000">宜昌市枝江市</option>
					<option value="420599000000">宜昌市市辖区</option>
					<option value="420600000000">湖北省襄阳市</option>
					<option value="420602000000">襄樊市襄城区</option>
					<option value="420606000000">襄樊市樊城区</option>
					<option value="420607000000">襄樊市襄阳区</option>
					<option value="420624000000">襄樊市南漳县</option>
					<option value="420625000000">襄樊市谷城县</option>
					<option value="420626000000">襄樊市保康县</option>
					<option value="420640000000">襄樊市高新技术开发区</option>
					<option value="420682000000">襄樊市老河口市</option>
					<option value="420683000000">襄樊市枣阳市</option>
					<option value="420684000000">襄樊市宜城市</option>
					<option value="420699000000">襄阳市市辖区</option>
					<option value="420700000000">湖北省鄂州市</option>
					<option value="420702000000">鄂州市梁子湖区</option>
					<option value="420703000000">鄂州市华容区</option>
					<option value="420704000000">鄂州市鄂城区</option>
					<option value="420740000000">鄂州市葛店开发区</option>
					<option value="420741000000">鄂州市长港农场</option>
					<option value="420799000000">鄂州市市辖区</option>
					<option value="420800000000">湖北省荆门市</option>
					<option value="420802000000">荆门市东宝区</option>
					<option value="420804000000">荆门市掇刀区</option>
					<option value="420821000000">荆门市京山县</option>
					<option value="420822000000">荆门市沙洋县</option>
					<option value="420840000000">屈家岭管理区</option>
					<option value="420881000000">荆门市钟祥市</option>
					<option value="420899000000">荆门市市辖区</option>
					<option value="420900000000">湖北省孝感市</option>
					<option value="420902000000">孝感市孝南区</option>
					<option value="420921000000">孝感市孝昌县</option>
					<option value="420922000000">孝感市大悟县</option>
					<option value="420923000000">孝感市云梦县</option>
					<option value="420981000000">孝感市应城市</option>
					<option value="420982000000">孝感市安陆市</option>
					<option value="420984000000">孝感市汉川市</option>
					<option value="420999000000">孝感市市辖区</option>
					<option value="421000000000">湖北省荆州市</option>
					<option value="421002000000">荆州市沙市区</option>
					<option value="421003000000">荆州市荆州区</option>
					<option value="421004000000">荆州市开发区</option>
					<option value="421022000000">荆州市公安县</option>
					<option value="421023000000">荆州市监利县</option>
					<option value="421024000000">荆州市江陵县</option>
					<option value="421081000000">荆州市石首市</option>
					<option value="421083000000">荆州市洪湖市</option>
					<option value="421087000000">荆州市松滋市</option>
					<option value="421099000000">荆州市市辖区</option>
					<option value="421100000000">湖北省黄冈市</option>
					<option value="421102000000">黄冈市黄州区</option>
					<option value="421121000000">黄冈市团风县</option>
					<option value="421122000000">黄冈市红安县</option>
					<option value="421123000000">黄冈市罗田县</option>
					<option value="421124000000">黄冈市英山县</option>
					<option value="421125000000">黄冈市浠水县</option>
					<option value="421126000000">黄冈市蕲春县</option>
					<option value="421127000000">黄冈市黄梅县</option>
					<option value="421181000000">黄冈市麻城市</option>
					<option value="421182000000">黄冈市武穴市</option>
					<option value="421199000000">黄冈市市辖区</option>
					<option value="421200000000">湖北省咸宁市</option>
					<option value="421202000000">咸宁市咸安区</option>
					<option value="421221000000">咸宁市嘉鱼县</option>
					<option value="421222000000">咸宁市通城县</option>
					<option value="421223000000">咸宁市崇阳县</option>
					<option value="421224000000">咸宁市通山县</option>
					<option value="421281000000">咸宁市赤壁市</option>
					<option value="421299000000">咸宁市市辖区</option>
					<option value="421300000000">湖北省随州市</option>
					<option value="421302000000">随州市曾都区</option>
					<option value="421321000000">随州市随县</option>
					<option value="421381000000">随州市广水市</option>
					<option value="421399000000">随州市市本级</option>
					<option value="422800000000">湖北省恩施土家族苗族自治州</option>
					<option value="422801000000">恩施州恩施市</option>
					<option value="422802000000">恩施州利川市</option>
					<option value="422822000000">恩施州建始县</option>
					<option value="422823000000">恩施州巴东县</option>
					<option value="422825000000">恩施州宣恩县</option>
					<option value="422826000000">恩施州咸丰县</option>
					<option value="422827000000">恩施州来凤县</option>
					<option value="422828000000">恩施州鹤峰县</option>
					<option value="422899000000">恩施土家族苗族自治州州本级</option>
					<option value="429000000000">省直辖县级行政单位</option>
					<option value="429004000000">湖北省仙桃市</option>
					<option value="429005000000">湖北省潜江市</option>
					<option value="429006000000">湖北省天门市</option>
					<option value="429021000000">湖北省神农架林区</option>
					<option value="429900000000">湖北省省本级</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="telephone" name="telephone">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>学历：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="education" class="select">
					<option value="">--请选择--</option>
					<option value="1">本科</option>
					<option value="2">研究生</option>
					<option value="3">博士</option>
					<option value="4">博士后</option>
					<option value="5">大专</option>
					<option value="6">高中及以下</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否参保：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">是</option>
					<option value="2">否</option>
				</select>
				</span> </div>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第三步：补贴信息</span></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>银行户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开户银行：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>银行账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>入学日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="birthday" class="input-text" type="text" onClick="WdatePicker()" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>人员类别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="education" class="select">
					<option value="">--请选择--</option>
					<option value="1">城镇登记失业人员</option>
					<option value="2">农村转移就业劳动者</option>
					<option value="3">毕业年度高校毕业生</option>
					<option value="4">城乡未继续升学的应届初高中毕业生</option>
					<option value="5">监狱服刑人员</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>缴纳学费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>补贴标准</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>补贴支付对象：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="education" class="select">
					<option value="">--请选择--</option>
					<option value="1">培训机构</option>
					<option value="2">个人</option>
				</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否中途退学：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>退学日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="birthday" class="input-text" type="text" onClick="WdatePicker()" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否有培训前证书：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>培训前证书等级：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">职业资格一级(高级技师)</option>
					<option value="2">职业资格二级(技师)</option>
					<option value="3">职业资格三级(高级)</option>
					<option value="4">职业资格四级(中级)</option>
					<option value="5">职业资格五级(初级)</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>培训前证明名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否使用培训券：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>培训券号码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>是否企业新录用员工：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>合同期限（年）：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="email" maxlength="30" class="input-text" value="" placeholder="" id="email" name="email">
			</div>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">第四步：选择班级</span></div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>班级：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="insuredstate" class="select">
					<option value="">--请选择--</option>
					<c:forEach items="${cls}" var="s" varStatus="st">
						<option value="${s.class_id}">${s.class_name}</option>
					</c:forEach>
					<!-- <option value="234">xxx2班</option> -->
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
<!-- 				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button> -->
				<!-- <button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button> -->
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="lib/idcardreader/jmidcardreader.js"></script>


<script type="text/javascript">
$(function(){
	$.fn.serializeObject = function()    
	{    
	   var o = {};    
	   var a = this.serializeArray();    
	   $.each(a, function() {    
	       if (o[this.name]) {    
	           if (!o[this.name].push) {    
	               o[this.name] = [o[this.name]];    
	           }    
	           o[this.name].push(this.value || '');    
	       } else {
	       	   if (this.value != ""){    
	           		o[this.name] = this.value || '';    
	       	   }
	       }    
	   });    
	   return o;    
	};

	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	//表单验证
	$("#form-article-add").validate({
		rules:{
			name:{
				required:true,
			},
			gender:{
				required:true,
			},
			birthday:{
				required:true,
				date:true,
			},
			telephone:{
				required:true,
				number:true,
			},
			email:{
				required:true,
				email:true,
			},
			address:{
				required:true,
			},
			nation:{
				required:true,
			},
			education:{
				required:true,
			},
			insuredstate:{
				required:true,
			},
			state:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
		  	var options = {  
                type: 'GET',//提交方式  
                url:  'student-add/submit',
                data:{
                	studentid:0,
                	state:1,
                },
                contentType:'application/json;charset=UTF-8',
                success: function() {
                	var index = parent.layer.getFrameIndex(window.name);
					parent.location.replace(parent.location.href)
					parent.layer.close(index);
					removeIframe();
                }   
            };
			$(form).ajaxSubmit(options);
		}
	});
	
	$list = $("#fileList"),
	$btn = $("#btn-star"),
	state = "pending",
	uploader;

	var uploader = WebUploader.create({
		auto: true,
		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
		// 文件接收服务端。
		server: 'fileupload.php',
	
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#filePicker',
	
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize: false,
		// 只允许选择图片文件。
		accept: {
			title: 'Images',
			extensions: 'gif,jpg,jpeg,bmp,png',
			mimeTypes: 'image/*'
		}
	});
	uploader.on( 'fileQueued', function( file ) {
		var $li = $(
			'<div id="' + file.id + '" class="item">' +
				'<div class="pic-box"><img></div>'+
				'<div class="info">' + file.name + '</div>' +
				'<p class="state">等待上传...</p>'+
			'</div>'
		),
		$img = $li.find('img');
		$list.append( $li );
	
		// 创建缩略图
		// 如果为非图片文件，可以不用调用此方法。
		// thumbnailWidth x thumbnailHeight 为 100 x 100
		uploader.makeThumb( file, function( error, src ) {
			if ( error ) {
				$img.replaceWith('<span>不能预览</span>');
				return;
			}
	
			$img.attr( 'src', src );
		}, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
		var $li = $( '#'+file.id ),
			$percent = $li.find('.progress-box .sr-only');
	
		// 避免重复创建
		if ( !$percent.length ) {
			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
		}
		$li.find(".state").text("上传中");
		$percent.css( 'width', percentage * 100 + '%' );
	});
	
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file ) {
		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
	});
	
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
	});
	
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
		$( '#'+file.id ).find('.progress-box').fadeOut();
	});
	uploader.on('all', function (type) {
        if (type === 'startUpload') {
            state = 'uploading';
        } else if (type === 'stopUpload') {
            state = 'paused';
        } else if (type === 'uploadFinished') {
            state = 'done';
        }

        if (state === 'uploading') {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on('click', function () {
        if (state === 'uploading') {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
	
	var ue = UE.getEditor('editor');
	
});


function getMockData(){
	
	var json = eval('(' + idcardreader.get_idcarinfo() + ')');
	document.getElementById("cardId").value=json.sfzh;
	document.getElementById("cardName").value=json.xm;
	if (json.sex=="男"){
	document.getElementById("gender").value="1";
	}else{
		document.getElementById("gender").value="0";
		}
	document.getElementById("nation").value=json.mile;
	document.getElementById("birthday").value=json.birthday;
	document.getElementById("address").value=json.adr1+json.adr2;
}

function article_save_submit(){
	var data = $("#form-article-add").serializeObject(); //自动将form表单封装成json 
    alert(JSON.stringify(data));
    $.ajax({
        type: "POST",   //访问WebService使用Post方式请求
        contentType: "application/json", //WebService 会返回Json类型
        url: "student-add/submit", //调用WebService的地址和方法名称组合 ---- WsURL/方法名
        data: JSON.stringify(data),         //这里是要传递的参数，格式为 data: "{paraName:paraValue}",下面将会看到      
        dataType: 'json',
       	success: function (result) {     //回调函数，result，返回值
            layer.msg('已修改成功!',{icon: 6,time:1000});
			var index = parent.layer.getFrameIndex(window.name);
			parent.location.replace(parent.location.href)
        }
    }); 
}

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>