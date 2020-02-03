package com.gxuwz.Market.business.action.web.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gxuwz.Market.business.entity.Topic;
import com.gxuwz.Market.business.entity.TopicBank;
import com.gxuwz.Market.business.entity.Testpaper;
import com.gxuwz.Market.business.service.ITopicBankService;
import com.gxuwz.Market.business.service.TopicService;
import com.gxuwz.Market.util.ZipUtilToFile;
import com.gxuwz.core.pagination.Result;
import com.gxuwz.core.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 *<p>Title:TopicAction</p>
 *<p>Description:简答题</p>
 * @author 赵艳梅
 * @date 2020年1月3日下午7:18:16
 */
@SuppressWarnings("serial")
public class TopicAction extends BaseAction implements Preparable, ModelDriven{
	
	protected static final String LIST_JSP = "/WEB-INF/page/topic/topic_list.jsp";
	protected static final String ADD_JSP = "/WEB-INF/page/topic/topic_add.jsp";
	protected static final String EDIT_JSP = "/WEB-INF/page/topic/topic_edit.jsp";
	protected static final String VIEW_JSP = "/WEB-INF/page/topic/topic_preview.jsp";
	protected static final String ADDTOPIC_JSP = "/WEB-INF/page/topic/topic_to_paper.jsp";
	protected static final String BATCHADD_JSP = "/WEB-INF/page/topic/topic_batch_add.jsp";
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	private Result<Topic> pageResult; //分页
	private Topic topic;
	private Testpaper testpaper;
	private String topicBankName;
	private TopicBank topicBank;
	
	//定义一个InputStream流[实现zip压缩包定义的对象]
    private  InputStream  inputStreamAll;
    private String inputPathforAll ;
    private String fileNameforAll ;
    
    //批量导入的声明
    private File myFile;
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	public Log getLogger() {
		return logger;
	}

	@Autowired
	private TopicService topicService;
	@Autowired
	private ITopicBankService topicBankService;
	@Override
	public void prepare() throws Exception {
		if(null == topic){
			topic = new Topic();
			topicBank = new TopicBank();
		}
		if(null == testpaper){
			testpaper = new Testpaper();
		}
	}

	/**
	 * 获取试题列表
	 * *  @return
	 */
	public String list()throws Exception{
		logger.info("##topic列表读取...");
		pageResult = topicService.find(topic, getPage(), getRow());
		
//		 List<String> TopicBankNameList=topicService.getTopicBankNameAll();
//		getRequest().getSession().setAttribute("TopicBankNameList",TopicBankNameList);
//		
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	/**
	 * 添加试题
	 *  @return
	 */
	public String add() throws Exception{
		topicBank =  topicBankService.findByName(topic.getTopicBankName());
		topic.setTopicBankId(topicBank.getTopicBankId());
		topicService.add(topic);
		topic = new Topic();
		return list();
	}
	
	/**
	 * 保存修改信息
	 *  @return
	 */
	public String update() throws Exception{
		topicService.update(topic);
		topic.setId(null);
		topic.setDescription(null);
		topic.setTopicBankName(null);
		return list();
	}
	
	/**
	 * 删除试题
	 *  @return
	 */
	public String delete() throws Exception{
		topicService.delete(topic.getId());
		topic.setDescription(null);
		topic.setId(null);
		return list();
	}
	
	/**
	 * 页面跳转
	 * @return
	 * @author zym
	 * @date 2019.8.10
	 */
	public String openList(){
		return SUCCESS;
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String openAdd(){
		forwardView = ADD_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到批量添加页面
	 * @return
	 */
	public String openBatchAdd(){
		forwardView = BATCHADD_JSP;
		return SUCCESS;
	}
	/**
	 * 跳转到修改试题页面
	 * @return
	 * @author
	 */
	public String openEdit(){
		topic = topicService.findById(topic.getId());
		forwardView = EDIT_JSP;
		return SUCCESS;
	}
	
	/**
	 * 跳转到试题预览页面
	 * @author zym
	 */
	public String openView(){
		topic = topicService.findById(topic.getId());
		forwardView = VIEW_JSP;
		return SUCCESS;
	}

	/**
	 * 根据题库名字查询试题列表
	 * @return
	 * @throws Exception
	 */
	public String getlistByTopicBankName()throws Exception{
		logger.info("##Topic列表读取...");
		pageResult = topicService.getlistByTopicBankName(topic, getPage(), getRow(), topic.getTopicBankName());
		/*String a = ServletActionContext.getRequest().getParameter("topicBankName");
		System.out.println("topicBankName===="+a);*/	//获取页面传过来的topicBankName	
		setForwardView(LIST_JSP);
		return SUCCESS;
	}
	
	
	@Override
	public Object getModel() {
		return topic;
	}

	public Result<Topic> getPageResult() {
		return pageResult;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public void setPageResult(Result<Topic> pageResult) {
		this.pageResult = pageResult;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getTopicBankName() {
		return topicBankName;
	}

	public void setTopicBankName(String topicBankName) {
		this.topicBankName = topicBankName;
	}
	public Testpaper getTestpaper() {
		return testpaper;
	}

	public void setTestpaper(Testpaper testpaper) {
		this.testpaper = testpaper;
	}

	public TopicBank getTopicBank() {
		return topicBank;
	}

	public void setTopicBank(TopicBank topicBank) {
		this.topicBank = topicBank;
	}


	/**
	 * 
	 * @author zym
	 * @date 下午10:53:48
	 * @description Excel批量导入
	 */
	public String importXls() throws Exception{
		String flag = "1";
		try{
		    //使用POI接口解析Excel文件
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(myFile));
			System.out.println(myFile);
			//获得第一个sheet页
			XSSFSheet sheet = workbook.getSheetAt(0);
			//集合
			List<Topic> list = new ArrayList<Topic>();
			for(Row row : sheet){
				int rowNum = row.getRowNum();
				if(rowNum == 0){
					//忽略第一行
					continue;
				}
				String description =  row.getCell(0).getStringCellValue(); 
				String difficulty =  row.getCell(1).getStringCellValue(); 
				String type = "简答题";
				String knowledge = row.getCell(2).getStringCellValue();
				String topicBankName = topic.getTopicBankName();
				System.out.println("topicBankName=="+topicBankName);
				String answer = row.getCell(3).getStringCellValue();
				String creator = (String) getRequest().getSession().getAttribute("userName");
				System.out.println("creator=="+creator);
				Topic topic = new Topic(description,difficulty,type,knowledge,topicBankName,answer,creator);
				list.add(topic);
			}
			topicService.addBatch(list);
		}catch (Exception e) {
			flag = "0";
			System.out.println("e.getMessage()=="+e.getMessage());
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(flag);
		return NONE;
	}
	
	
	
	
        
        //提供他的get和set方法
        public InputStream getInputStreamAll() throws Exception {
            return inputStreamAll;
        }
        public void setInputStreamAll(InputStream inputStreamAll) throws Exception {
            this.inputStreamAll = inputStreamAll;
        }
        //编写具体的下载方法提供给前端调用
	    /**
	     * 文件打包下载
	     * @return
	     
	    public String downloadFileAll() {
	        //查询出后台的文件列表
	        JdbcTemplate jdbcTemplateExtend = SpringContextUtil.getBean("jdbcTemplate");
	        CommonManager commonManager = SpringContextUtil.getBean("commonManager");
	        List<Map> queryForList = jdbcTemplate.queryForList("select * from  FILE where id='" + id + "'");
	        //获取上传到服务器的文件夹/uploadfile
	        String prefix = ServletActionContext.getServletContext().getRealPath("/uploadfile");
	        //new一个ArrayList用来存放具体的文件
	        ArrayList<String> zipFile = new ArrayList<String>();
	        //遍历出集合中的文件
	        for (Map map : queryForList) {
	            String fileName = (String) map.get("FILE_NAME");
	            //把文件存储到我们之前定义的ArrayList集合中
	            zipFile.add(prefix+File.separator+fileName );
	        }
	        //使用一个临时目录uploadZip用来存放打包好的ZIP文件
	        String zipPath = ServletActionContext.getServletContext().getRealPath("/uploadZip/");
	        //为打包的zip文件创建一个名称,以时间戳区分
	        String formatDate =new  SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        //添加文件名的后缀
	        String fileName = formatDate + ".zip";
	        //定义文件的输出路径
	        String path = zipPath +File.separator +fileName;
	        //使用ZIP工具类来压缩zipFile集合中添加的列表文件
	        ZipUtilToFile.compressFile(zipFile, path);
	        //保存到临时目录
	        inputPathforAll = zipPath+ "\\uploadZip\\" + fileName;
	        try {
	            //文件名称
	            fileNameforAll =  new String(fileName.getBytes(), "ISO8859-1");
	            this.setInputStreamAll(new FileInputStream(new File(path)));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return SUCCESS;
	    } */
	    
//	    /**
//		 * 试卷列表点击添加试题后的试题列表
//		 *  @return
//		 */
//		public String openTopicList()throws Exception{
//			logger.info("##试题列表读取...");
//			int testpaperId = testpaper.getTestpaperId();
//			System.out.println("testpaperId=="+testpaperId);
//			getRequest().getSession().setAttribute("testpaperId",testpaperId);
//			pageResult = topicService.find(topic, getPage(), getRow());
//			setForwardView(ADDTOPIC_JSP);
//			return SUCCESS;
//		}
//	/**
//	 * 删除课题
//	 * @return
//	 * @throws Exception
//	 */
//	public String delete1() throws Exception {
//		topicService.delete(topic.getId());
//		setForwardView(LIST_JSP);
//		return SUCCESS;
//	}
}
