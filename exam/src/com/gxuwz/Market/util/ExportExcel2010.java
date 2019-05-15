package com.gxuwz.Market.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




//
//import com.gxuwz.Market.business.entity.AreaStatis;
//import com.gxuwz.Market.business.entity.MessageStatis;
//import com.gxuwz.Market.business.entity.News;

import util.MyTime;


public class ExportExcel2010 {
//    
//    /**
//     * 使用XSSFWorkbook处理office2007以上的excel
//     * @param list
//     * @param sheetName
//     * @return
//     * @throws Exception
//     */
//    public XSSFWorkbook writeXlsx(List<ServiceQrcodeInfo> list, String sheetName) throws Exception {
//        if (list == null) {
//            return null;
//        }
//        //XSSFWorkbook
//        int countColumnNum = list.size();
//        XSSFWorkbook book = new XSSFWorkbook();
//        System.out.println("执行到new XSSFWorkbook");
//        XSSFSheet sheet = book.createSheet(sheetName);
//        // option at first row.
//        XSSFRow firstRow = sheet.createRow(0);
//        XSSFCell[] firstCells = new XSSFCell[countColumnNum];
//        String[] options = { "二维码序号", "龟苓膏“一物一码”值", "状态（1-已打印，0-未打印）","年份","生成批次"};
//        for (int j = 0; j < options.length; j++) {
//            firstCells[j] = firstRow.createCell(j);
//            firstCells[j].setCellValue(new XSSFRichTextString(options[j]));
//        }
//        //
//        for (int i = 0; i < countColumnNum; i++) {
//            XSSFRow row = sheet.createRow(i + 1);
//            ServiceQrcodeInfo serviceQrcodeInfo = list.get(i);
//            for (int column = 0; column < options.length; column++) {
//                XSSFCell qrNum = row.createCell(0);
//                XSSFCell qrKey = row.createCell(1);
//                XSSFCell qrState = row.createCell(2);
//                XSSFCell cyear = row.createCell(3);
//                XSSFCell createBatch = row.createCell(4);
//                qrNum.setCellValue(serviceQrcodeInfo.getQrNum());
//                qrKey.setCellValue(serviceQrcodeInfo.getQrKey());
//                qrState.setCellValue("0");
//                cyear.setCellValue(serviceQrcodeInfo.getCyear());
//                createBatch.setCellValue(serviceQrcodeInfo.getCreateBatch());
//            }
//            if(i%1000==0){
//            	System.out.println("完成1000，"+i);
//            }
//        }
//        System.out.println("XSSFWorkbook组装完成");
//        /*File file = new File(path);
//        OutputStream os = new FileOutputStream(file);
//        System.out.println(Common.WRITE_DATA + path);
//        book.write(os);
//        os.close();*/
//        return book;
//    }
//    


    /**
     * 使用XSSFWorkbook处理office2007以上的excel
     * @param list
     * @param sheetName
     * @return
     * @throws Exception
     * 导出订单数据
     */
//    public static SXSSFWorkbook writeMessageStatisXlsxSXSS(List<MessageStatis> list, String sheetName){
//        if (list == null) {
//            return null;
//        }
//        //XSSFWorkbook
//        int countColumnNum = list.size();
//        int rowaccess=100;//内存中缓存记录行数
//        /*keep 100 rowsin memory,exceeding rows will be flushed to disk*/
//        SXSSFWorkbook book = new SXSSFWorkbook(rowaccess);
//        System.out.println("执行到new XSSFWorkbook");
//        Sheet sh = book.createSheet(sheetName);
//        // option at first row.
//        Row firstRow = sh.createRow(0);
//        String[] options = { "日期", "公共安全", "司法执法","党风建设","城市管理", "公共服务", "市政建设","教育教学","社会民生", "劳资纠纷", "公共管理","医疗卫生","其他舆情","总数"};
//        for (int j = 0; j < options.length; j++) {
//        	  Cell cell = firstRow.createCell(j);
//              cell.setCellValue(options[j]);
//        }
//        try {
//            for (int i = 0; i < countColumnNum; i++) {
//                Row row = sh.createRow(i + 1);
//                MessageStatis medicalOrder = list.get(i);
//                for (int column = 0; column < options.length; column++) {
//                	Cell orderId = row.createCell(0);
//                	Cell orderUserName = row.createCell(1);
//                	Cell orderUserCertinum = row.createCell(2);
//                	Cell orderUserCertitype = row.createCell(3);
//                	Cell orderUserPhone = row.createCell(4);
//                	Cell orderUserEmail = row.createCell(5);
//                	Cell orderUserDate = row.createCell(6);
//                	Cell orderUserAddress = row.createCell(7);
//                	Cell orderProductName = row.createCell(8);
//                	Cell orderProductJianum = row.createCell(9);
//                	Cell orderProductMerchant = row.createCell(10);
//                	Cell orderProductPrice = row.createCell(11);
//                	Cell orderProductHks = row.createCell(12);
//                	Cell orderIspay = row.createCell(13);
//                	
//                	
//                	orderId.setCellValue(medicalOrder.getDate());
//                	orderUserName.setCellValue(medicalOrder.getClass1());
//                	orderUserCertinum.setCellValue(medicalOrder.getClass2());
//                	
//                    orderUserCertitype.setCellValue(medicalOrder.getClass3());
//				
//                	orderUserPhone.setCellValue(medicalOrder.getClass4());
//                	orderUserEmail.setCellValue(medicalOrder.getClass5());
//                	orderUserDate.setCellValue(medicalOrder.getClass6());
//                	orderUserAddress.setCellValue(medicalOrder.getClass7());
//                	orderProductName.setCellValue(medicalOrder.getClass8());
//                	orderProductJianum.setCellValue(medicalOrder.getClass9());
//                	orderProductMerchant.setCellValue(medicalOrder.getClass10());
//                	orderProductPrice.setCellValue(medicalOrder.getClass11());
//                	orderProductHks.setCellValue(medicalOrder.getClass12());
//                	orderIspay.setCellValue(medicalOrder.getTotal());
//	
//                   
//                }
//                if(i%rowaccess==0){
//                	//System.out.println("完成"+rowaccess+","+i);
//                	((SXSSFSheet)sh).flushRows();
//                }
//            }
//        	((SXSSFSheet)sh).flushRows();
//		} catch (Exception e) {
//			System.out.println("writeXlsxSXSS出错："+e);
//		}finally{
//        	try {
//				((SXSSFSheet)sh).flushRows();
//			} catch (IOException e) {
//				System.out.println("writeXlsxSXSS,finally出错："+e);
//			}
//		}
//        System.out.println("XSSFWorkbook组装完成");
//        return book;
//    }
//    
    
    /**
     * 使用XSSFWorkbook处理office2007以上的excel
     * @param list
     * @param sheetName
     * @return
     * @throws Exception
     * 导出用户预定数据
     */
//    public static SXSSFWorkbook writeAreaStatisXlsxSXSS(List<AreaStatis> list, String sheetName){
//    	  if (list == null) {
//              return null;
//          }
//          //XSSFWorkbook
//          int countColumnNum = list.size();
//          int rowaccess=100;//内存中缓存记录行数
//          /*keep 100 rowsin memory,exceeding rows will be flushed to disk*/
//          SXSSFWorkbook book = new SXSSFWorkbook(rowaccess);
//          System.out.println("执行到new XSSFWorkbook");
//          Sheet sh = book.createSheet();
//          // option at first row.
//          Row firstRow = sh.createRow(0);
//          String[] options = { "日期", "万秀区", "长洲区","龙须区","岑溪市", "苍梧县", "藤县","蒙山县","总数"};
//          for (int j = 0; j < options.length; j++) {
//        	  Cell cell = firstRow.createCell(j);
//              cell.setCellValue(options[j]);
//          }
//          try {
//              for (int i = 0; i < countColumnNum; i++) {
//                  Row row = sh.createRow(i + 1);
//                  AreaStatis excelAppoint = list.get(i);
//                  for (int column = 0; column < options.length; column++) {
//                	  
//                  	Cell appointId = row.createCell(0);
//                  	Cell userName = row.createCell(1);
//                  	Cell userPingyin = row.createCell(2);
//                  	Cell userAge = row.createCell(3);
//                  	Cell userSex = row.createCell(4);
//                  	Cell userCertitype = row.createCell(5);
//                  	Cell userCertinum = row.createCell(6);
//                  	Cell userPhone = row.createCell(7);
//                  	Cell userEmail = row.createCell(8);
//                  	
//                  	
//                  	
//                  	appointId.setCellValue(excelAppoint.getDate());
//                  	userName.setCellValue(excelAppoint.getClass1());
//                  	userPingyin.setCellValue(excelAppoint.getClass2());	
//                  	userAge.setCellValue(excelAppoint.getClass3());
//                  	userSex.setCellValue(excelAppoint.getClass4());	
//                  	userCertitype.setCellValue(excelAppoint.getClass5());
//                  	userCertinum.setCellValue(excelAppoint.getClass6());
//                  	userPhone.setCellValue(excelAppoint.getClass7());
//                  	userEmail.setCellValue(excelAppoint.getTotal());
//                  
//                     
//                  }
//                  if(i%rowaccess==0){
//                  	//System.out.println("完成"+rowaccess+","+i);
//                  	((SXSSFSheet)sh).flushRows();
//                  }
//              }
//          	((SXSSFSheet)sh).flushRows();
//  		} catch (Exception e) {
//  			System.out.println("writeXlsxSXSS出错："+e);
//  		}finally{
//          	try {
//  				((SXSSFSheet)sh).flushRows();
//  			} catch (IOException e) {
//  				System.out.println("writeXlsxSXSS,finally出错："+e);
//  			}
//  		}
//          System.out.println("XSSFWorkbook组装完成");
//          return book;
//    }
    
    
    /**
     * 使用XSSFWorkbook处理office2007以上的excel
     * @param list
     * @param sheetName
     * @return
     * @throws Exception
     * 导出历史审核数据
     */
//    public static SXSSFWorkbook writeHistoryNewsXlsxSXSS(List<News> list, String sheetName){
//    	if (list == null) {
//            return null;
//        }
//    	int countColumnNum = list.size();
//        int rowaccess=100;//内存中缓存记录行数
//        /*keep 100 rowsin memory,exceeding rows will be flushed to disk*/
//        SXSSFWorkbook book = new SXSSFWorkbook(rowaccess);
//        System.out.println("执行到new XSSFWorkbook");
//        Sheet sh = book.createSheet();
//        // option at first row.
//        Row firstRow = sh.createRow(0);
//        String[] options = { "日期", "标题", "链接"};
//        for (int j = 0; j < options.length; j++) {
//      	  Cell cell = firstRow.createCell(j);
//            cell.setCellValue(options[j]);
//        }
//        
//        try {
//            for (int i = 0; i < countColumnNum; i++) {
//                Row row = sh.createRow(i + 1);
//                News news = list.get(i);
//                for (int column = 0; column < options.length; column++) {
//              	  
//                	Cell date = row.createCell(0);
//                	Cell title = row.createCell(1);
//                	Cell link = row.createCell(2);
//                	
//                	date.setCellValue(news.getNewsTime());
//                	title.setCellValue(news.getNewsTitle());
//                	link.setCellValue(news.getNewsUrl());	
//                	
//                }
//                if(i%rowaccess==0){
//                	//System.out.println("完成"+rowaccess+","+i);
//                	((SXSSFSheet)sh).flushRows();
//                }
//            }
//        	((SXSSFSheet)sh).flushRows();
//		} catch (Exception e) {
//			System.out.println("writeXlsxSXSS出错："+e);
//		}finally{
//        	try {
//				((SXSSFSheet)sh).flushRows();
//			} catch (IOException e) {
//				System.out.println("writeXlsxSXSS,finally出错："+e);
//			}
//		}
//        System.out.println("XSSFWorkbook组装完成");
//        return book;
//        
//        
//    }
    
    
//    
//    /**
//     * 把系统内部对账单转换为XSSFWorkbook以便导出
//     * @param list 系统内部对账单
//     * @param sheetName 导出的excel的名字
//     * @return XSSFWorkbook对象
//     * @throws Exception
//     */
//    public static XSSFWorkbook financeProofread(List<ServiceFinanceProofread> list, String sheetName) throws Exception {
//        if (null == list) {
//            return null;
//        }
//        //XSSFWorkbook
//        int countColumnNum = 14;
//        XSSFWorkbook book = new XSSFWorkbook();
//        System.out.println("执行到new XSSFWorkbook");
//        XSSFSheet sheet = book.createSheet(sheetName);
//        // option at first row.
//       
//        XSSFCell[] firstCells = new XSSFCell[countColumnNum];
//        //第一行设置发放总金额，发送成功总金额，退款总金额
//        XSSFRow secondRow = sheet.createRow(0);
//        secondRow.setHeight((short) 500);//设置第一行的行高
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
//        //sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 5));
//        //sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));
//        //sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 12));
//
//        String strCell = "";
//        firstCells[0] = secondRow.createCell(0);
//		Double lotterTotalMoney = (double) 0;//发送的总金额（包括发送中的和已领取的）
//		Double lotterSuccessTotalMoney = (double) 0;//发送未领取的金额
//		Double lotterReturnTotalMoney = (double) 0;//退款总金额
//		Double lotterFailTotalMoney = 0D;//发送失败的金额
//		System.out.println("list----"+list.size());
//		if (list.size() > 0) {
//			if(null != list.get(0) && null != list.get(0).getLotterTotalMoney()){
//				lotterTotalMoney = list.get(0).getLotterTotalMoney();
//			}
//			if(null != list.get(0) && null != list.get(0).getLotterSuccessTotalMoney()){
//				lotterSuccessTotalMoney = list.get(0).getLotterSuccessTotalMoney();
//			}
//			if(null != list.get(0) && null != list.get(0).getLotterSuccessTotalMoney()){
//				lotterReturnTotalMoney = list.get(0).getLotterSuccessTotalMoney();
//			}
//			if(null != list.get(0) && null != list.get(0).getLotterSuccessTotalMoney()){
//				lotterFailTotalMoney = list.get(0).getLotterSuccessTotalMoney();
//			}
//		}
//        strCell = strCell + "扣款（已发红包）总金额："+lotterTotalMoney;
//        strCell = strCell + "，发送未领取总金额："+lotterSuccessTotalMoney;
//        strCell = strCell + "，退款总金额："+lotterReturnTotalMoney;
//        strCell = strCell + "，支付失败或者红包状态异常："+lotterFailTotalMoney;
//        firstCells[0].setCellValue(strCell);
//        
//        /*firstCells[3] = secondRow.createCell(3);
//        firstCells[3].setCellValue("发送未领取总金额："+list.get(0).getLotterSuccessTotalMoney());
//        
//        firstCells[6] = secondRow.createCell(6);
//        firstCells[6].setCellValue("退款总金额："+list.get(0).getLotterReturnTotalMoney());
//        
//        firstCells[9] = secondRow.createCell(9);
//        firstCells[9].setCellValue("支付失败或者红包状态异常："+list.get(0).getLotterFailTotalMoney());*/
//        
//        XSSFRow firstRow = sheet.createRow(1);
//        String[] options = { "抽奖日期", "领取日期", "中奖者账号唯一码","中奖者名称","中奖区域","中奖等级", "奖金",
//        		"中奖码段","产品批号","中奖名额","未兑奖退款给日期","未兑奖退款金额","备注"};
//        for (int j = 0; j < options.length; j++) {
//            firstCells[j] = firstRow.createCell(j);
//            firstCells[j].setCellValue(new XSSFRichTextString(options[j]));
//        }
//        
//        //
//        for (int i = 0; i < list.size(); i++) {
//            XSSFRow row = sheet.createRow(i + 2);
//            ServiceFinanceProofread serviceFinanceProofread = list.get(i);
//            for (int column = 0; column < options.length; column++) {
//                XSSFCell cjTime = row.createCell(0);
//                XSSFCell receiveTime = row.createCell(1);
//                XSSFCell wxOpenid = row.createCell(2);
//                XSSFCell nickname = row.createCell(3);
//                XSSFCell lotteryArea = row.createCell(4);
//                XSSFCell lotteryGrade = row.createCell(5);
//                XSSFCell awardvalue = row.createCell(6);
//                XSSFCell codePassage = row.createCell(7);
//                XSSFCell createBatch = row.createCell(8);
//                XSSFCell awardNum = row.createCell(9);
//                XSSFCell refundTime = row.createCell(10);
//                XSSFCell refundMoney = row.createCell(11);
//                XSSFCell remarks = row.createCell(12);
//                
//                if (null != list.get(i).getCjTime())
//                cjTime.setCellValue(""+list.get(i).getCjTime());
//                if (null != list.get(i).getReceiveTime())
//                receiveTime.setCellValue(""+list.get(i).getReceiveTime());
//                if (null != list.get(i).getWxOpenid())
//                wxOpenid.setCellValue(""+list.get(i).getWxOpenid());
//                if (null != list.get(i).getNickname())
//                nickname.setCellValue(""+list.get(i).getNickname());
//                if (null != list.get(i).getLotteryArea())
//                lotteryArea.setCellValue(""+list.get(i).getLotteryArea());
//                if (null != list.get(i).getLotteryGrade())
//                lotteryGrade.setCellValue(""+list.get(i).getLotteryGrade());
//                if (null != list.get(i).getAwardvalue())
//                awardvalue.setCellValue(""+list.get(i).getAwardvalue());
//                if (null != list.get(i).getCodePassage())
//                codePassage.setCellValue(""+list.get(i).getCodePassage());
//                if (null != list.get(i).getCreateBatch())
//                createBatch.setCellValue(""+list.get(i).getCreateBatch());
//                if (null != list.get(i).getAwardNum())
//                awardNum.setCellValue(""+list.get(i).getAwardNum());
//                if (null != list.get(i).getRefundTime())
//                refundTime.setCellValue(""+list.get(i).getRefundTime());
//                if (null != list.get(i).getRefundMoney())
//                refundMoney.setCellValue(""+list.get(i).getRefundMoney());
//                remarks.setCellValue(list.get(i).getRemarks());
//            }
//            if(i%1000==0){
//            	System.out.println("完成1000，"+i);
//            }
//        }
//        System.out.println("XSSFWorkbook组装完成");
//        /*File file = new File(path);
//        OutputStream os = new FileOutputStream(file);
//        System.out.println(Common.WRITE_DATA + path);
//        book.write(os);
//        os.close();*/
//        return book;
//    }
//    
//    /**
//     * 把系统内部对账单转换为XSSFWorkbook以便导出
//     * @param list 系统内部对账单
//     * @param sheetName 导出的excel的名字
//     * @return XSSFWorkbook对象
//     * @throws Exception
//     */
//    public static SXSSFWorkbook financeProofreadSXSS(List<ServiceFinanceProofread> list, String sheetName) throws Exception {
//        if (null == list) {
//            return null;
//        }
//        //XSSFWorkbook
//        int countColumnNum = list.size();
//        int rowaccess=100;//内存中缓存记录行数
//        /*keep 100 rowsin memory,exceeding rows will be flushed to disk*/
//        SXSSFWorkbook book = new SXSSFWorkbook(rowaccess);
//        System.out.println("执行到new XSSFWorkbook");
//        Sheet sh = book.createSheet();
//        // option at first row.
//        Row firstRow = sh.createRow(0);
//        String[] options = { "抽奖日期", "领取日期", "中奖者账号唯一码","中奖者名称","中奖区域","中奖等级", "奖金",
//        		"中奖码段","产品批号","中奖名额","未兑奖退款给日期","未兑奖退款金额","备注"};
//        for (int j = 0; j < options.length; j++) {
//            Cell cell = firstRow.createCell(j);
//            cell.setCellValue(options[j]);
//        }
//        try {
//            for (int i = 0; i < countColumnNum; i++) {
//                Row row = sh.createRow(i + 1);
//                ServiceFinanceProofread serviceFinanceProofread = list.get(i);
//                for (int column = 0; column < options.length; column++) {
//                	Cell cjTime = row.createCell(0);
//                	Cell receiveTime = row.createCell(1);
//                	Cell wxOpenid = row.createCell(2);
//                	Cell nickname = row.createCell(3);
//                	Cell lotteryArea = row.createCell(4);
//                	Cell lotteryGrade = row.createCell(5);
//                	Cell awardvalue = row.createCell(6);
//                	Cell codePassage = row.createCell(7);
//                	Cell createBatch = row.createCell(8);
//                	Cell awardNum = row.createCell(9);
//                	Cell refundTime = row.createCell(10);
//                	Cell refundMoney = row.createCell(11);
//                	Cell remarks = row.createCell(12);
//                    
//                    if (null != list.get(i).getCjTime())
//                    cjTime.setCellValue(""+list.get(i).getCjTime());
//                    if (null != list.get(i).getReceiveTime())
//                    receiveTime.setCellValue(""+list.get(i).getReceiveTime());
//                    if (null != list.get(i).getWxOpenid())
//                    wxOpenid.setCellValue(""+list.get(i).getWxOpenid());
//                    if (null != list.get(i).getNickname())
//                    nickname.setCellValue(""+list.get(i).getNickname());
//                    if (null != list.get(i).getLotteryArea())
//                    lotteryArea.setCellValue(""+list.get(i).getLotteryArea());
//                    if (null != list.get(i).getLotteryGrade())
//                    lotteryGrade.setCellValue(""+list.get(i).getLotteryGrade());
//                    if (null != list.get(i).getAwardvalue()){
//                    	//awardvalue.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                    awardvalue.setCellValue(list.get(i).getAwardvalue().doubleValue());}
//                    if (null != list.get(i).getCodePassage())
//                    codePassage.setCellValue(""+list.get(i).getCodePassage());
//                    if (null != list.get(i).getCreateBatch())
//                    createBatch.setCellValue(""+list.get(i).getCreateBatch());
//                    if (null != list.get(i).getAwardNum())
//                    awardNum.setCellValue(""+list.get(i).getAwardNum());
//                    if (null != list.get(i).getRefundTime())
//                    refundTime.setCellValue(""+list.get(i).getRefundTime());
//                    if (null != list.get(i).getRefundMoney()){
//                    	awardvalue.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                    refundMoney.setCellValue(list.get(i).getRefundMoney().doubleValue());}
//                    remarks.setCellValue(list.get(i).getRemarks());
//                }
//                if(i%rowaccess==0){
//                	//System.out.println("完成"+rowaccess+","+i);
//                	((SXSSFSheet)sh).flushRows();
//                }
//            }
//        	((SXSSFSheet)sh).flushRows();
//		} catch (Exception e) {
//			System.out.println("writeXlsxSXSS出错："+e);
//		}finally{
//        	try {
//				((SXSSFSheet)sh).flushRows();
//			} catch (IOException e) {
//				System.out.println("writeXlsxSXSS,finally出错："+e);
//			}
//		}
//        System.out.println("XSSFWorkbook组装完成");
//        return book;
//    }
//
//    
//    /**
//     * 对账单(系统无记录，有流水)
//     * @param list 系统内部对账单
//     * @param sheetName 导出的excel的名字
//     * @return XSSFWorkbook对象
//     * @throws Exception
//     */
//    public static SXSSFWorkbook excelForServiceWxRedEnvelope(List<ServiceWxRedEnvelope> list, String sheetName) throws Exception {
//        if (null == list) {
//            return null;
//        }
//        //XSSFWorkbook
//        int countColumnNum = list.size();
//        int rowaccess=100;//内存中缓存记录行数
//        /*keep 100 rowsin memory,exceeding rows will be flushed to disk*/
//        SXSSFWorkbook book = new SXSSFWorkbook(rowaccess);
//        System.out.println("执行到new XSSFWorkbook");
//        Sheet sh = book.createSheet();
//        // option at first row.
//        Row firstRow = sh.createRow(0);
//        String[] options = { "入账时间", "交易单号", "商户单号","账务类型","收支类型","收支金额(元)", "导入批次","导入人"};
//        for (int j = 0; j < options.length; j++) {
//            Cell cell = firstRow.createCell(j);
//            //String address = new CellReference(cell).formatAsString();
//            cell.setCellValue(options[j]);
//        }
//        try {
//            for (int i = 0; i < countColumnNum; i++) {
//                Row row = sh.createRow(i + 1);
//                ServiceWxRedEnvelope serviceWxRedEnvelope = list.get(i);
//                for (int column = 0; column < options.length; column++) {
//                    Cell cell0 = row.createCell(0);
//                    Cell cell1 = row.createCell(1);
//                    Cell cell2 = row.createCell(2);
//                    Cell cell3 = row.createCell(3);
//                    Cell cell4 = row.createCell(4);
//                    Cell cell5 = row.createCell(5);
//                    Cell cell6 = row.createCell(6);
//                    Cell cell7 = row.createCell(7);
//                    if (null != list.get(i).getBillRegTime())
//                    	cell0.setCellValue(""+MyTime.getForTimestamp(list.get(i).getBillRegTime()));
//                    if (null != list.get(i).getTransactionNumber())
//                    	cell1.setCellValue(""+list.get(i).getTransactionNumber());
//                    if (null != list.get(i).getMchBillno())
//                    	cell2.setCellValue(""+list.get(i).getMchBillno());
//                    if (null != list.get(i).getImportTime())
//                    	cell3.setCellValue(""+list.get(i).getBillType());
//                    int numT = list.get(i).getInExType();
//                    if (1 == numT){
//                    	cell4.setCellValue("收入");
//                    }
//                    if (2 == numT){
//                    	cell4.setCellValue("支出");
//                    }
//                    if (null != list.get(i).getAwardvalue())
//                    	cell5.setCellValue(list.get(i).getAwardvalue().doubleValue());
//                    if (null != list.get(i).getImportTime())
//                    	cell6.setCellValue(""+MyTime.getForTimestamp(list.get(i).getImportTime()));
//                    if (null != list.get(i).getImportPerson())
//                    	cell7.setCellValue(""+list.get(i).getImportPerson());
//                }
//                if(i%rowaccess==0){
//                	//System.out.println("完成"+rowaccess+","+i);
//                	((SXSSFSheet)sh).flushRows();
//                }
//            }
//        	((SXSSFSheet)sh).flushRows();
//		} catch (Exception e) {
//			System.out.println("writeXlsxSXSS出错："+e);
//		}finally{
//        	try {
//				((SXSSFSheet)sh).flushRows();
//			} catch (IOException e) {
//				System.out.println("writeXlsxSXSS,finally出错："+e);
//			}
//		}
//        System.out.println("XSSFWorkbook组装完成");
//        return book;
//    }
    
    
    
}
