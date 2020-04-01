package com.gxuwz.Market.business.service;

import java.util.List;

import com.gxuwz.Market.business.entity.CorrectRate;

/**
 * 
 *<p>Title:ICorrectRateService</p>
 *<p>Description:</p>
 * @author 赵艳梅
 * @date 2020年3月31日下午6:10:44
 */

public interface ICorrectRateService {

	public void add(CorrectRate correctRate);

	public void update(CorrectRate correctRate);

	public CorrectRate findByTopicId(int topicId);
}
