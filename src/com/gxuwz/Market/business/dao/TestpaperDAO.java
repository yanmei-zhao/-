package com.gxuwz.Market.business.dao;



import java.util.ArrayList;

import java.util.List;



import java.util.HashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;










import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.wanghaomiao.seimi.struct.Request;

import com.google.gson.Gson;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.core.dao.impl.BaseDaoImpl;
import com.gxuwz.core.pagination.Result;

@Repository("TestpaperDAO")
public class TestpaperDAO extends BaseDaoImpl<Testpaper>{
	
	/**
	 * 根据条件查找分页
	 * @param SysRole 模型
	 * @param page 第几页
	 * @param row 长度
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Testpaper> find(Testpaper testpaper, int page, int row){
		String queryString="from Testpaper where 1=1";
		if(null != testpaper.getTestpaperId()){
			queryString = queryString + " and testpaperId like '%"+testpaper.getTestpaperId()+"%'";
		}
		if(null != testpaper.getTestpaperName()){
			queryString = queryString + " and testpaperName like '%"+testpaper.getTestpaperName()+"%'";
		}
		int start=(page-1)*row;
		int limit =row;
		
		return (Result<Testpaper>)super.find(queryString, null, null, start, limit);
	}
	/**
	 * 升序查询所有权限
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Testpaper> getAllTestpaper(){
		
		String queryString="from Testpaper where 1=1";
		return (List<Testpaper>) getHibernateTemplate().find(queryString);
	}
	
	public void updatetopic(){
		String queryString="from Testpaper where 1=1";
	}


	/**根据试卷名称查询试卷
	 * 根据property属性的值value获取对象
	 * @param property SysUser对象的属性
	 * @param value 值
	 * @return
	 */
/*	@SuppressWarnings("unchecked")
	public Testpaper fingById(String testpaperId){
		Testpaper testpaper = null;
		String hql = "from testpaper where testpaper_id = '"+testpaperId+"'";
		List<Testpaper> list = (List<Testpaper>) this.getHibernateTemplate().find(hql);
		if(null != list && 0<list.size()){
			testpaper = list.get(0);
		}
		return testpaper;
	}
*/	
	/**
	 * 查询所有试卷名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getTestpaperNameAll() {
		// TODO Auto-generated method stub
		String queryString="select testpaperName from Testpaper where 1=1";
	    return (List<String>) getHibernateTemplate().find(queryString);
	}
	/**
	 *  通过试卷id查询试题展示试卷
	 * @param testpaperId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllTopicId(Integer testpaperId){
		 List b = new ArrayList();
		 List c = new ArrayList();  //  用来存题目的数组
		// List d = new ArrayList();  //用来判断题目类型的数
		String hql="from Testpaper where testpaperId= '"+testpaperId+"'";
	   List<Testpaper> list = (List<Testpaper>) getHibernateTemplate().find(hql);
	                          
       for(Testpaper testpaper:list){
    	   if(list.size()>0){
    	   List a = new ArrayList();
         {
           a.add(testpaper.getTopicId());
        //   System.out.println(a.get(0));
           }
           b.addAll(a);  
           } 
       }
    
      for(int i=0;b.size()>i;i++){
    	  // Object a = b.get(i);
    	 //  String a1 = (String)a;
       String hql2="from Topic where topicId= '"+b.get(i)+"'";
       List<Topic> list2 = (List<Topic>) getHibernateTemplate().find(hql2);
      
      for(Topic topic:list2){
    	   List a2 = new ArrayList();
    	   if(list2.size()>0){
    		   a2.add(topic.getQuestion());
    		   a2.add(topic.getOptionA());
    		   a2.add(topic.getOptionB());
    		   a2.add(topic.getOptionC());
    		   a2.add(topic.getOptionD());
    		   System.out.println(a2.get(1));
    		 }  
    	   c.addAll(a2);
    	   }
    	  }
    return c;  
    	   
       }

}
