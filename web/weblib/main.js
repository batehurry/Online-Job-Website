/**
 * 引入js文件的通用函数
 * @param src js文件的路径
 */
function importJS(src) {
	document.write('<script src="' + qzw.basePath + '/weblib/' + src + '?version=' + qzw.version + '" charset="utf-8" type="text/javascript"></script>');
}

/**
 * 在浏览器控制台输出log
 * @param str 字符串
 */
function log(str) {
	if(window.console && window.console.log) {
		window.console.log(str);
	}
}

/**
 * 在浏览器控制台输出info
 * @param str 字符串
 */
function info(str) {
	if(window.console && window.console.info) {
		window.console.info(str);
	}
}

/* 引入jQuery */
importJS('js/jquery-1.11.3.min.js');
/* 引入bootstrap的js文件 */
importJS('js/bootstrap.min.js');
/* 引入iTsai-webtools的js文件 */
importJS('js/iTsai-webtools-min.js');
/* 引入bootstrapvalidator的js文件 */
importJS('lib/bootstrapvalidator/js/bootstrapValidator.min.js');
/* 引入bootstrapvalidator-language的js文件 */
importJS('lib/bootstrapvalidator/js/language/zh_CN.js');
/* 引入My97DatePicker的js文件 */
importJS('lib/My97DatePicker/WdatePicker.js');
/* 引入layer.js的js文件 */
importJS('lib/layer/layer.js');
/* 引入layer.ext.js的js文件 */
importJS('lib/layer/extend/layer.ext.js');
/* 引入laypage的js文件 */
importJS('lib/laypage/laypage.js');
/* 引入icheck的js文件 */
importJS('lib/icheck-1.x/icheck.min.js');
/* 引入zTree_v3的js文件 */
importJS('lib/zTree_v3/js/jquery.ztree.all-3.5.min.js');
/* 引入selectator的js文件 */
importJS('lib/selectator/fm.selectator.jquery.js');
/* 引入bootstrap-modal的js文件 */
importJS('lib/bootstrap-modal/js/bootstrap-modalmanager.js');
/* 引入bootstrap-modal的js文件 */
importJS('lib/bootstrap-modal/js/bootstrap-modal.js');
/* 引入bootstrap-table的js文件 */
importJS('lib/bootstrap-table/bootstrap-table.min.js');
/* 引入bootstrap-table的js文件 */
importJS('lib/bootstrap-table/bootstrap-table-locale-all.min.js');

/****************自定义函数******************/

/**
 * 关于本网站的介绍
 */
function aboutMe() {
	layer.alert('欢迎使用求职网,本网站项目是魏胜泽和郭妤的毕业设计,如有不足之处请指出,联系邮箱：w0612w@qq.com,谢谢');
}

/**
 * 新闻详情
 * @param id 新闻的id
 */
function newsDetail(id) {
	$.post(qzw.basePath + '/news/newsDetail.html', {'id' : id}, function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'新闻'
		});
	});
}

/**
 * 求职者的用户信息
 */
function userInfo1() {
	$.post(qzw.basePath + '/user/userInfoPage.html', function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'用户信息',
	        btn : ['确定', '取消'],
		    yes : function(index) {
				$.ajax({
		    		type : 'post',
		    		url : qzw.basePath + '/user/modUserInfo1.html',
		    		data : JSON.stringify(iTsai.form.serialize($('#userInfoForm'))),
		    		contentType : 'application/json',
		    		dataType : 'json',
		    		success : function(data) {
		    			layer.msg(data.msg);
		    		}
		    	});
				layer.close(index);
		    },
		    btn2 : function(index) {
		    	layer.close(index);
		    }
		});
	});
}

/**
 * 企业的用户信息
 */
function userInfo2() {
	$.post(qzw.basePath + '/user/userInfoPage.html', function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'用户信息',
	        btn : ['确定', '取消'],
		    yes : function(index) {
		    	$.ajax({
		    		type : 'post',
		    		url : qzw.basePath + '/user/modUserInfo2.html',
		    		data : JSON.stringify(iTsai.form.serialize($('#userInfoForm'))),
		    		contentType : 'application/json',
		    		dataType : 'json',
		    		success : function(data) {
		    			layer.msg(data.msg);
		    		}
		    	});
				layer.close(index);
		    },
		    btn2 : function(index) {
		    	layer.close(index);
		    }
		});
	});
}

/**
 * 修改密码
 */
function modPwd() {
	$.post(qzw.basePath + '/user/modPwdPage.html', function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'修改密码',
	        btn : ['确定', '取消'],
		    yes : function(index) {
		    	var json = iTsai.form.serialize($('#modPwdForm'));
				$.post(qzw.basePath + '/user/modPwd.html', {'pwd' : json.userPwd}, function(data) {
					layer.msg(data.msg);
				}, 'json');
				layer.close(index);
		    },
		    btn2 : function(index) {
		    	layer.close(index);
		    }
		});
	});
}

/**
 * 初始化区域选择树
 * @param obj input(text)
 */
function areaTree(obj) {
	layer.open({
	    type : 2,
	    area : ['300px', '550px'],
	    fix : false, //不固定
	    maxmin : false,
	    shadeClose : false, //点击遮罩关闭
	    title : '请选择',
	    content : qzw.basePath + '/area.html',
	    btn : ['确定', '清除', '取消'],
	    yes : function(index) {
	    	var selNodes = top.treeObj.getSelectedNodes();
	    	if (selNodes.length > 0) {
		    	$(obj).val(_nodeText(selNodes));
		    	layer.close(index);
	    	} else {
	    		layer.msg('请选择一个地区');
	    	}
	    },
	    btn2 : function(index) {
	    	$(obj).val('');
	    	layer.close(index);
	    },
	    btn3 : function(index) {
	    	layer.close(index);
	    }
	});
}

/**
 * 获取区域树选择的名称
 * @param selNodes
 * @returns {String}
 */
function _nodeText(selNodes) {
	var selNodeText = '';
	var node = selNodes[0].getPath();
	for(var i = 0; i < node.length; i++) {
		selNodeText += node[i].name + '>';
	}
	if(selNodeText != '') {
		selNodeText = selNodeText.substr(0, selNodeText.length - 1);
	}
	return selNodeText;
}

/**
 * 通过所选行业加载相关职位
 * @param obj 行业 input
 * @param postInput 职位input的id
 */
function loadPost(obj, postInputId) {
	var industryId = $(obj).val();
	$.post(qzw.basePath + '/position/loadPosition.html',{'id' : industryId}, function(data) {
		var content = '';
		if(data.length == 0) {
			layer.alert('该行业下暂时没有职位！', function(index) {
				$('#' + postInputId).html('');
				layer.close(index);
			});
		} else {
			content += '<option value="">---请选择---</option>';
			for(var i in data) {
				content += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
			}
			$('#' + postInputId).html(content);
		}
	},'json');
}

/**
 * 打开表单页面
 * @param detailUrl
 * @param saveUrl
 * @param editUrl
 * @param table
 * @param form
 * @param json
 */
function openDetail(detailUrl, saveUrl, editUrl, table, form, json) {
	 $.post(detailUrl, function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'操作窗口',
	        btn : ['确认', '取消'],
	        yes : function(index, layero){
	        	if (json != undefined) {
	        		submit(saveUrl, editUrl, table, form);
	        		layer.close(index);
	        	} else {
	        		var isValid = $('#' + form).data('bootstrapValidator').isValid();
		        	if (isValid == true) {
		        		submit(saveUrl, editUrl, table, form);
		        		layer.close(index);
		        	} else {
		        		layer.msg('请按正确格式填写');
		        	}
	        	}
		    },
		    success : function(layero, index) {
		    	$('#' + form)[0].reset();
		    	if (json != undefined) {
		    		// 行业职位联动回显
			    	if (json.position != undefined && json.position.industry != undefined && json.position.industry.id != undefined && '' != json.position.industry.id) {
			    		$.post(qzw.basePath + '/position/loadPosition.html',{id : json.position.industry.id}, function(data) {
			    			var content = '';
			    			if(data.length == 0) {
			    				layer.alert('该行业下暂时没有职位可以发布招聘！', function(index) {
			    					$('#' + postInputId).html('');
			    					layer.close(index);
			    				});
			    			} else {
			    				for(var i in data) {
			    					content += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
			    				}
			    				$('#postSelect').html(content);
			    				json.industry = json.position.industry.id;
			    				iTsai.form.deserialize($('#' + form), json);
			    			}
			    		},'json');
					} else {
						iTsai.form.deserialize($('#' + form), json);
					}
				}
		    }
	    });
	});
}

/**
 * 查看详细信息页面
 * @param detailUrl
 * @param form
 */
function openLookDetail(detailUrl) {
	$.post(qzw.basePath + '/' + detailUrl, function(data) {
		layer.open({
	        type : 1,
	        content : data,
	        scrollbar : false,
	        area : '550px',
	        title :'详情'
		});
	});
}

/**
 * 修改Bootstrap Table中的数据
 * @param detailUrl
 * @param saveUrl
 * @param editUrl
 * @param table
 * @param form
 */
function edit(detailUrl, saveUrl, editUrl, table, form) {
	var rows = $('#' + table).bootstrapTable('getSelections');
	if (rows.length == 0) {
		layer.msg('请选择一个进行修改！');
	} else if (rows.length > 1) {
		layer.msg('只能选择一个进行修改，但您选择了' + rows.length + '个！');
	} else {
		openDetail(detailUrl, saveUrl, editUrl, table, form, rows[0]);
	}
}

/**
 * 提交Bootstrap Table中的数据
 * @param saveUrl
 * @param editUrl
 * @param table
 * @param form
 */
function submit(saveUrl, editUrl, table, form) {
	var url = saveUrl;
	var id = $('#' + form).find('input[name=id]').val();
	if(id != null && id != '') {
		url = editUrl;
	}
	$.ajax({
		type : 'post',
		url : url,
		data : JSON.stringify(iTsai.form.serialize($('#' + form))),
		contentType : 'application/json',
		dataType : 'json',
		success : function(data) {
			layer.msg(data.msg);
			$('#' + table).bootstrapTable('refresh');
		}
	});
}

/**
 * 删除Bootstrap Table中的数据
 * @param deleteUrl
 * @param table
 */
function delte(deleteUrl, table) {
	var rows = $('#' + table).bootstrapTable('getSelections');
	var ids = [];
	if (rows.length > 0) {
		layer.confirm('您确定吗？', {
			btn : [ '确定', '取消' ]
		}, function() {
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$.post(deleteUrl, {ids : ids.join(',')}, function(data) {
				layer.msg(data.msg);
				$('#' + table).bootstrapTable('refresh');
			}, 'json');
		});
	} else {
		layer.msg('请选择删除的项目！');
	}
}

/**
 * 投递简历
 * @param table
 */
function sendVitae(table) {
	var rows = $('#' + table).bootstrapTable('getSelections');
	var ids = [];
	if (rows.length > 0) {
		$.post(qzw.basePath + '/vitae/chooseVitae.html', function(data) {
			layer.open({
		        type : 1,
		        content : data,
		        scrollbar : false,
		        area : '550px',
		        title :'请选择简历',
		        btn : ['确定', '取消'],
			    yes : function(index) {
			    	for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
			    	var json = iTsai.form.serialize($('#chooseVitaeForm'));
					$.post(qzw.basePath + '/vitaeRecord/saveVitaeRecord.html', {'vitae.id' : json.vitaeId, 'ids' : ids.join(',')}, function(data) {
						layer.msg(data.msg);
						$('#' + table).bootstrapTable('refresh');
					}, 'json');
					layer.close(index);
			    },
			    btn2 : function(index) {
			    	layer.close(index);
			    }
			});
		});
	} else {
		layer.msg('请选择要发送简历的职位！');
	}
}

/**
 * 通过简历
 * @param table
 */
function pass(table) {
	var rows = $('#' + table).bootstrapTable('getSelections');
	var ids = [];
	if (rows.length > 0) {
		$.post(qzw.basePath + '/vitaeRecord/chooseInterviewDate.html', function(data) {
			layer.open({
		        type : 1,
		        content : data,
		        scrollbar : false,
		        area : '550px',
		        title :'请选择面试时间',
		        btn : ['确定', '取消'],
			    yes : function(index) {
			    	for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
			    	var json = iTsai.form.serialize($('#chooseInterviewDateForm'));
					$.post(qzw.basePath + '/vitaeRecord/updateVitaeRecordPass.html', {'interviewDate' : json.interviewDate, 'ids' : ids.join(',')}, function(data) {
						layer.msg(data.msg);
						$('#' + table).bootstrapTable('refresh');
					}, 'json');
					layer.close(index);
			    },
			    btn2 : function(index) {
			    	layer.close(index);
			    }
			});
		});
	} else {
		layer.msg('请选择要操作的项目！');
	}
}

/**
 * 拒绝简历
 * @param table
 */
function refuse(table) {
	var rows = $('#' + table).bootstrapTable('getSelections');
	var ids = [];
	if (rows.length > 0) {
		layer.confirm('您确定要拒绝吗？', {
			btn : [ '拒绝', '取消' ]
		}, function() {
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$.post(qzw.basePath + '/vitaeRecord/updateVitaeRecordRefuse.html', {ids : ids.join(',')}, function(data) {
				layer.msg(data.msg);
				$('#' + table).bootstrapTable('refresh');
			}, 'json');
		});
	} else {
		layer.msg('请选择要操作的项目！');
	}
}