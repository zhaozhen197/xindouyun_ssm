<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="Author" contect="">
    <title>信息填写</title>
    <link href="<%=basePath%>select/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="<%=basePath%>select/js/jquery.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>select/js/rem.js" type="text/javascript"></script>
</head>
<body>
<div class="content invoice_cont">
    <div class="header">
        <div class="head">
            <a href="javascript:;" onclick="javascript:history.back(-1);" class="back"></a>
            信息填写
        </div>
    </div>
    <div class="forms">
        <form id="form1" method="post" action="<%=basePath%>user/inputInfo">

            <input id="setPhone" name="phone" type="hidden">
            <div class="formList clearfix">
                <div class="formTi float-l">申请金额(万)<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input id="loanMoney" name="loanMoney" type="number" placeholder="请输入您所申请的贷款金额"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">申请期限(月)<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input name="loanTimeLimit" type="number" placeholder="请输入您贷款期限"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">本人姓名<span class="red">*</span></div>
                <div class="form_input float-l">
                    <input name="name2" type="text" placeholder="请输入"/>
                </div>
            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">职业身份<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select id="identity" name="identity" class="form_sel">
                        <option value="0">请选择</option>
                        <option value="wage_earners">工薪族</option>
                        <option value="business_owner">企业主</option>
                        <option value="person">个体户</option>
                        <option value="other">其他</option>
                    </select>
                </div>
            </div>
            <div id="identitydiv">

            </div>


            <div class="formList clearfix">
                <div class="formTi float-l">本地公积金<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select id="fundSel" name="fund" class="form_sel">
                        <option value="0">无</option>
                        <option value="1">有</option>
                    </select>
                </div>
            </div>

            <div id="funddiv">

            </div>


            <div class="formList clearfix">
                <div class="formTi float-l">本地社保<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select name="socialSecurity" class="form_sel">
                        <option value="0">无</option>
                        <option value="1">有</option>
                    </select>
                </div>
            </div>


            <div class="formList clearfix">
                <div class="formTi float-l">名下是否有房<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select name="house" id="houseSel" class="form_sel">
                        <option value="0">无房</option>
                        <option value="fullPaymentHouse">全款房</option>
                        <option value="mortgageHouse">按揭房</option>
                    </select>
                </div>
            </div>

            <div id="houseDiv">


            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">名下是否有车<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select id="carSel" name="car" class="form_sel">
                        <option value="0">无车</option>
                        <option value="fullPaymentCar">全款车</option>
                        <option value="mortgageCar">按揭车</option>
                    </select>
                </div>
            </div>

            <div id="carDiv">


            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">是否购买人寿保险<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select id="insuranceSel" name="insurance" class="form_sel">
                        <option value="0">无</option>
                        <option value="1">有</option>
                    </select>
                </div>
            </div>
            <div id="insuranceDiv">


            </div>
            <div class="formList clearfix">
                <div class="formTi float-l">征信<span class="red">*</span></div>
                <div class="form_input float-l">
                    <select name="credit" class="form_sel">
                        <option value="0">请选择</option>
                        <option value="1">信用良好</option>
                        <option value="2">半年内逾期超过2次或者30天以上逾期</option>
                        <option value="3">一年内逾期超过3次或者90天以上逾期</option>
                        <option value="4">无信用卡贷款</option>
                    </select>
                </div>
            </div>


            <%--<div class="fuwuxuzhi"><label for="xuzhi"><input type="checkbox" checked id="xuzhi"/>已阅读</label> <span--%>
            <%--class="red">服务须知</span></div>--%>
            <button type="button" id="button1" class="formsub" style="margin:.7rem auto .5rem auto;">提交
            </button>
        </form>
    </div>

</div>

<!--提示-->
<%--<div class="tip-success-bg tip-tip-box">--%>
<%--<div class="tip-tip-box-nei">--%>
<%--<strong id="tishiyu">错误提示</strong>--%>
<%--</div><!--tip-tip-box/-->--%>
<%--</div><!--tip-success-bg/-->--%>


<div class="bg100"></div>
<script type="text/javascript">

    $(document).ready(function () {
        //设置电话号码
        setPhoneHidden();
        $("#identity").change(function () {
            var data = $("#identity").val();
            switch (data) {
                case "wage_earners":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        " <div  class=\"formList clearfix\">\n" +
                        "                <div class=\"formTi float-l\">工资发放形式<span class=\"red\">*</span></div>\n" +
                        "                <div class=\"form_input float-l\">\n" +
                        "                    <select id=\"identity1\" name=\"salaryType\" class=\"form_sel\">\n" +
                        "                        <option value=\"0\">请选择</option>\n" +
                        "                        <option value=\"bank\">银行卡发放</option>\n" +
                        "                        <option value=\"cash\">现金发放</option>\n" +
                        "                    </select>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div  class=\"formList clearfix\">\n" +
                        "                <div class=\"formTi float-l\">连续打卡时间<span class=\"red\">*</span></div>\n" +
                        "                <div class=\"form_input float-l\">\n" +
                        "                    <select id=\"identity2\" name=\"punchTime\" class=\"form_sel\">\n" +
                        "                        <option value=\"0\">请选择</option>\n" +
                        "                        <option value=\"oneYearMore\">一年以上</option>\n" +
                        "                        <option value=\"lessThreeMonth\">未满三个月</option>\n" +
                        "                        <option value=\"aboutSixMonth\">满六个月</option>\n" +
                        "                        <option value=\"oneYear\">满一年</option>\n" +
                        "                    </select>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div  class=\"formList clearfix\">\n" +
                        "                <div class=\"formTi float-l\">公司性质<span class=\"red\">*</span></div>\n" +
                        "                <div class=\"form_input float-l\">\n" +
                        "                    <select  name=\"companytype\" class=\"form_sel\">\n" +
                        "                        <option value=\"0\">请选择</option>\n" +
                        "                        <option value=\"government\">企业事业单位</option>\n" +
                        "                        <option value=\"state_owned\">国有企业</option>\n" +
                        "                        <option value=\"share\">合资企业/股份制企业</option>\n" +
                        "                        <option value=\"personal_company\">私营企业/个体工商业</option>\n" +
                        "                        <option value=\"foreign_company\">外资企业</option>\n" +
                        "                        <option value=\"listed_company\">上市公司</option>\n" +
                        "                        <option value=\"top_500\">500强/上市公司</option>\n" +
                        "                    </select>\n" +
                        "                </div>\n" +
                        "            </div>"
                    )
                    break;
                case "business_owner":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        "<div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">个人月均流水<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"personalExpenses\" type=\"text\" placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">对公月均流水<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"companyExpenses\" type=\"text\" placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">经营年限<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"operationYears\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"lessSixMonth\">注册不满六个月</option>\n" +
                        "                            <option value=\"moreSixMonth\">注册满6到12个月</option>\n" +
                        "                            <option value=\"oneYear\">注册满1年</option>\n" +
                        "                            <option value=\"twoYear\">2年内</option>\n" +
                        "                            <option value=\"threeYear\">3年内</option>\n" +
                        "                            <option value=\"moreThreeYear\">3年以上</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">经营地<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"locationOfCompany\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"local\">本地</option>\n" +
                        "                            <option value=\"non_local\">外地</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">是否注册营业执照<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"license\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"1\">是</option>\n" +
                        "                            <option value=\"-1\">否</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>"
                    );

                    break;
                case "person":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        "<div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">个人月均流水<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"personalExpenses\" type=\"text\" placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">个人现金流水<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"cashExpenses\" type=\"text\" placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">经营年限<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"operationYears\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"lessSixMonth\">注册不满六个月</option>\n" +
                        "                            <option value=\"moreSixMonth\">注册满6到12个月</option>\n" +
                        "                            <option value=\"oneYear\">注册满1年</option>\n" +
                        "                            <option value=\"twoYear\">2年内</option>\n" +
                        "                            <option value=\"threeYear\">3年内</option>\n" +
                        "                            <option value=\"moreThreeYear\">3年以上</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">经营地<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"locationOfCompany\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"local\">本地</option>\n" +
                        "                            <option value=\"non_local\">外地</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "\n" +
                        "\n" +
                        "                <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">是否注册营业执照<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <select name=\"license\" class=\"form_sel\">\n" +
                        "                            <option value=\"0\">请选择</option>\n" +
                        "                            <option value=\"1\">是</option>\n" +
                        "                            <option value=\"-1\">否</option>\n" +
                        "                        </select>\n" +
                        "                    </div>\n" +
                        "                </div>"
                    );
                    break;
                case "other":
                    $("#identitydiv").empty();
                    $("#identitydiv").append(
                        " <div class=\"formList clearfix\">\n" +
                        "                    <div class=\"formTi float-l\">现金收入/月(元)<span class=\"red\">*</span></div>\n" +
                        "                    <div class=\"form_input float-l\">\n" +
                        "                        <input name=\"cashIncome\" type=\"number\" placeholder=\"请输入\"/>\n" +
                        "                    </div>\n" +
                        "                </div>"
                    );
                    break;
                default:
                    $("#identitydiv").empty(

                    );
            }
        })

    });


    // 公积金
    $("#fundSel").change(function () {
        var data = $("#fundSel").val();
        switch (data) {
            case "1":
                $("#funddiv").empty();
                $("#funddiv").append(
                    " <div class=\"formList clearfix\">\n" +
                    "                <div class=\"formTi float-l\">缴费额度<span class=\"red\">*</span></div>\n" +
                    "                <div class=\"form_input float-l\">\n" +
                    "                    <input name=\"fundMoney\" type=\"number\"  placeholder=\"请输入\"/>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <div class=\"formList clearfix\">\n" +
                    "                <div class=\"formTi float-l\">连续缴纳时间(月)<span class=\"red\">*</span></div>\n" +
                    "                <div class=\"form_input float-l\">\n" +
                    "                    <input name=\"paymentTime\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                </div>\n" +
                    "            </div>"
                );
                break;
            default:
                $("#funddiv").empty();

        }
    });


    // 购房
    $("#houseSel").change(function () {
        var data = $("#houseSel").val();
        switch (data) {
            case "fullPaymentHouse":
                $("#houseDiv").empty();
                $("#houseDiv").append(
                    "<div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">房子市值(万)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"marketValue\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">产权人数<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"rightOfPeoplenumber\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
                break;
            case  "mortgageHouse":
                 $("#houseDiv").empty();
                $("#houseDiv").append(
                    " <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">是否主贷人<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <select name=\"mianLoanPerson\" class=\"form_sel\">\n" +
                    "                            <option value=\"0\">否</option>\n" +
                    "                            <option value=\"1\">是</option>\n" +
                    "                        </select>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">月供金额(元)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"moneyEveryMonthHouse\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">月供时间(月)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"monthOfLoanHouse\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
                break;
            default:
                $("#houseDiv").empty();

        }
    });

    // 购车
    $("#carSel").change(function () {
        var data = $("#carSel").val();
        switch (data) {
            case "fullPaymentCar":
                $("#carDiv").empty();
                $("#carDiv").append(
                    "<div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">裸车价(万)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"carValue\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">车子年限(年)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"carYears\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
                break;
            case "mortgageCar":
                $("#carDiv").empty();
                $("#carDiv").append(
                "\n" +
                "                <div class=\"formList clearfix\">\n" +
                "                    <div class=\"formTi float-l\">月供金额(元)<span class=\"red\">*</span></div>\n" +
                "                    <div class=\"form_input float-l\">\n" +
                "                        <input name=\"moneyEveryMonthCar\" type=\"number\" placeholder=\"请输入\"/>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"formList clearfix\">\n" +
                "                    <div class=\"formTi float-l\">月供时间(月)<span class=\"red\">*</span></div>\n" +
                "                    <div class=\"form_input float-l\">\n" +
                "                        <input name=\"monthOfLoanCar\" type=\"number\" placeholder=\"请输入\"/>\n" +
                "                    </div>\n" +
                "                </div>")
                break;
            default:
                $("#carDiv").empty();

        }
    });


    //保险
    $("#insuranceSel").change(function () {
        var data = $("#insuranceSel").val();
        switch (data) {
            case "1":
                $("#insuranceDiv").empty();
                $("#insuranceDiv").append(
                    "<div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">是否投保人<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <select name=\"insuranceOrNot\" class=\"form_sel\">\n" +
                    "                            <option value=\"0\">否</option>\n" +
                    "                            <option value=\"1\">是</option>\n" +
                    "                        </select>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">保单公司<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"companyOfInsurance\" type=\"text\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">年交金额(元)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"moneyOfYearInsurance\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <div class=\"formList clearfix\">\n" +
                    "                    <div class=\"formTi float-l\">缴费年限(年)<span class=\"red\">*</span></div>\n" +
                    "                    <div class=\"form_input float-l\">\n" +
                    "                        <input name=\"yearsOfInsurance\" type=\"number\" placeholder=\"请输入\"/>\n" +
                    "                    </div>\n" +
                    "                </div>"
                );
                break;

            default:
                $("#insuranceDiv").empty();

        }
    });

    $("#button1").click(
        function () {
            var money = $("input[name='loanMoney']").val();
            var loanTimeLimit = $("input[name='loanTimeLimit']").val();
            var name = $("input[name='name2']").val();

            var g = /^[1-9]*[1-9][0-9]*$/;
            var flag = 1;
            if (money == "" || money == null || money == undefined) {
                alert("贷款金额不能为空！");
                flag = 0;
            } else if (!g.test(money)) {
                flag = 0;
                alert("贷款金额只能是数字")
            } else if (loanTimeLimit == "" || loanTimeLimit == null || loanTimeLimit == undefined) {
                alert("贷款期限不能为空");
                flag = 0;
            } else if (!g.test(loanTimeLimit)) {
                alert("贷款期限只能是数字")
                flag = 0;
            } else if (name == "" || name == null || name == undefined) {
                flag = 0;
                alert("本人姓名不能为空！")
            }
            if (flag == 1) {
                $("#form1").submit();
                alert("信息提交成功！")
            } else {
                return;
            }
        });

    /**
     * 获取地址栏中传过来的电话号码
     * @returns {string[]}
     * @constructor
     */
    function setPhoneHidden() {
        var url = document.location.toString();
        var arrUrl = url.split("&");
        var paras = arrUrl[1];
        var par = paras.split("=");
        $("#setPhone").val(par[1]);
    }
</script>

</body>
</html>