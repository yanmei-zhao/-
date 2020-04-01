package com.gxuwz.Market.business.action.web.front;

import com.gxuwz.Market.business.entity.CorrectRate;
import com.gxuwz.Market.business.service.ICorrectRateService;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 *<p>Title:CorrectRateAction</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年3月31日下午6:06:23
 */
public class CorrectRateAction extends BaseAction implements Preparable, ModelDriven{

	private static final long serialVersionUID = -3964870987940380211L;
	private CorrectRate correctRate;
	private ICorrectRateService correctRateService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		if(null == correctRate){
			correctRate = new CorrectRate();
		}
	}

	/**
	 * 添加比率个例
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		correctRateService.add(correctRate);
		return null;
	}
	
	/**
	 * 保存修改信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		correctRateService.update(correctRate);
		return null;
	}
	
}
