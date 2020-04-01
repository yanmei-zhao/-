package com.gxuwz.Market.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 *<p>Title:ZipUtilToFile</p>
 *<p>Description:压缩文件</p>
 * @author 赵艳梅
 * @date 2020年1月6日下午3:18:52
 */
public class ZipUtilToFile {
	public static void compressFile(File[] srcFile,String destFile) {
        OutputStream outputStream=null;
        ZipOutputStream zipOutputStream=null;
        try {
            outputStream=new FileOutputStream(new File(destFile));
            zipOutputStream=new ZipOutputStream(outputStream);
           // zipOutputStream.setEncoding("utf-8");

            for(File file:srcFile) {
                startZip(zipOutputStream,"",file);
            }

            //File file=new File(srcFile);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(zipOutputStream!=null) {
                    zipOutputStream.close();
                }
                if(outputStream!=null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


  /*  public static void compressFile(List<String> srcFile,String destFile) {
        OutputStream outputStream=null;
        ZipOutputStream zipOutputStream=null;
        try {
            outputStream=new FileOutputStream(new File(destFile));
            zipOutputStream=new ZipOutputStream(outputStream);
            zipOutputStream.setEncoding("utf-8");

            for(String str:srcFile) {
                File file=new File(str);
                startZip(zipOutputStream,"",file);
            }
            //File file=new File(srcFile);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(zipOutputStream!=null) {
                    zipOutputStream.close();
                }
                if(outputStream!=null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public static void startZip(ZipOutputStream zipOutputStream,String oppositePath,File file) {
        InputStream inputStream=null;
        BufferedInputStream bufferedInputStream=null;
        try {
            System.out.println("当前压缩目录或文件："+file.getName());
            //目录
            if(file.isDirectory()) {
                //若是目录创建目录
                String newoppositePath1=oppositePath+file.getName()+"/";
                ZipEntry zipEntry1=new ZipEntry(newoppositePath1);
                zipOutputStream.putNextEntry(zipEntry1);
                zipOutputStream.closeEntry();
                File[] files=file.listFiles();
                for(File f:files) {
                    if(f.isDirectory()) {
                        //创建压缩文件的目录结构
//                      String newoppositePath2=newoppositePath1+f.getName()+"/";
//                      
//                      ZipEntry zipEntry2=new ZipEntry(newoppositePath2);
//                      zipOutputStream.putNextEntry(zipEntry2);
//                      zipOutputStream.closeEntry();
                        startZip(zipOutputStream,newoppositePath1,f);
                    //文件    
                    }else {
                        zipFile(zipOutputStream,newoppositePath1,f);
                    }
                }

            //文件
            }else {
                zipFile(zipOutputStream,oppositePath,file);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedInputStream!=null) {
                    bufferedInputStream.close();
                }
                if(inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void zipFile(ZipOutputStream zipOutputStream,String oppositePath,File file) {
        //System.out.println("正在压缩文件："+file.getName());
        InputStream inputStream=null;
        BufferedInputStream bufferedInputStream=null;

        try {
            zipOutputStream.putNextEntry(new ZipEntry(oppositePath+file.getName()));
            inputStream=new FileInputStream(file);
            bufferedInputStream=new BufferedInputStream(inputStream);
            byte[] buffer=new byte[bufferedInputStream.available()];
            Integer length=null;
            while((length=bufferedInputStream.read(buffer))!=-1) {
                zipOutputStream.write(buffer, 0, length);
            }
            zipOutputStream.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param zipPath
     * @param outPath 该参数最后要加File.separator，例c:\data\
     */
   /* public static void decomprecessFile(String zipPath,String outPath) {
        OutputStream outputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        InputStream inputStream=null;
        BufferedInputStream bufferedInputStream=null;
        CheckedInputStream checkedInputStream=null;
        try {
            ZipFile zipFile=new ZipFile(zipPath,"UTF-8");
            //获取压缩文件中的所有项
            for(Enumeration<ZipEntry> enumeration=zipFile.getEntries();enumeration.hasMoreElements();) {
                ZipEntry zipEntry=(ZipEntry) enumeration.nextElement();
                System.out.println(zipEntry.getName());
                //目录，创建目录
                if(zipEntry.getName().endsWith("/")) {
                    File f=new File(outPath+zipEntry.getName());
                    f.mkdirs();
                //文件，创建文件   
                }else {
                    outputStream=new FileOutputStream(outPath+zipEntry.getName());
                    bufferedOutputStream=new BufferedOutputStream(outputStream);

                    inputStream=zipFile.getInputStream(zipEntry);
                    bufferedInputStream=new BufferedInputStream(inputStream);

                    checkedInputStream=new CheckedInputStream(bufferedInputStream,new CRC32());
                    byte[] buffer=new byte[bufferedInputStream.available()];
                    Integer length=null;
                    while((length=checkedInputStream.read(buffer))!=-1) {
                        bufferedOutputStream.write(buffer, 0, length);
                    }
                    bufferedOutputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedOutputStream!=null) {
                    bufferedOutputStream.close();
                }
                if(outputStream!=null) {
                    outputStream.close();
                }
                if(checkedInputStream!=null) {
                    checkedInputStream.close();
                }
                if(bufferedInputStream!=null) {
                    bufferedInputStream.close();
                }
                if(inputStream!=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
