package com.gxuwz.Market.business.action.web.front;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@SuppressWarnings("serial")
public class StatisticsAction  extends BaseAction implements Preparable, ModelDriven{
	protected static final String VIEW_JSP = "/WEB-INF/page/statistics/examination_analysis.jsp";
	protected final Log logger=LogFactory.getLog(getClass());
	
	public Log getLogger() {
		return logger;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
	}
	
	
	public String openAnalyze()throws Exception{
		setForwardView(VIEW_JSP);
		return SUCCESS;
		}

}
