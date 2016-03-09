package com.qzw.common;

import com.qzw.bean.Area;
import com.qzw.bean.Dict;
import com.qzw.bean.DictType;
import com.qzw.bean.EducationExp;
import com.qzw.bean.Enterprise;
import com.qzw.bean.Industry;
import com.qzw.bean.Jobhunter;
import com.qzw.bean.News;
import com.qzw.bean.Position;
import com.qzw.bean.PublishPosition;
import com.qzw.bean.Role;
import com.qzw.bean.User;
import com.qzw.bean.Vitae;
import com.qzw.bean.VitaeRecord;
import com.qzw.bean.WorkExp;
import com.qzw.entity.TArea;
import com.qzw.entity.TDict;
import com.qzw.entity.TDictType;
import com.qzw.entity.TEducationExp;
import com.qzw.entity.TEnterprise;
import com.qzw.entity.TIndustry;
import com.qzw.entity.TJobhunter;
import com.qzw.entity.TNews;
import com.qzw.entity.TPosition;
import com.qzw.entity.TPublishPosition;
import com.qzw.entity.TRole;
import com.qzw.entity.TUser;
import com.qzw.entity.TVitae;
import com.qzw.entity.TVitaeRecord;
import com.qzw.entity.TWorkExp;

public interface AllJO {

	static final Class<?>[] VO_CLASS = new Class<?>[]{
		//所有前台页面的实体VO
		Area.class,
		Dict.class,
		DictType.class,
		EducationExp.class,
		Enterprise.class,
		Industry.class,
		Jobhunter.class,
		News.class,
		Position.class,
		PublishPosition.class,
		Role.class,
		User.class,
		Vitae.class,
		VitaeRecord.class,
		WorkExp.class,
	};
	
	static final Class<?>[] PO_CLASS = new Class<?>[]{
		//所有数据库的实体PO
		TArea.class,
		TDict.class,
		TDictType.class,
		TEducationExp.class,
		TEnterprise.class,
		TIndustry.class,
		TJobhunter.class,
		TNews.class,
		TPosition.class,
		TPublishPosition.class,
		TRole.class,
		TUser.class,
		TVitae.class,
		TVitaeRecord.class,
		TWorkExp.class
	};
}