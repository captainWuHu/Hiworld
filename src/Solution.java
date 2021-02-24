import jdk.jfr.Timespan;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution<Public> {
    public static void main(String[] args) {
        for(int i =0;i<75;i++){
            System.out.println((char)('0'+i));
        }
    }
    public void creatClass(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入类名");
        String ClassName = s.next();
        System.out.println("输入类型");
        String paramName = s.next();
        System.out.println("请输入变量名");
        String name = s.next();
        String upName = Character.toUpperCase(name.charAt(0))+name.substring(1);
        String classModel = null;
        File model = new File("D:\\java file test\\model.txt");
        try(FileReader fd =new FileReader(model)){
            char[] bytes = new char[(int)model.length()];
            fd.read(bytes);
            classModel = new String(bytes);
        }catch(IOException e){
            e.printStackTrace();
        }
        assert classModel != null;
        String classReal = classModel.replaceAll("@class@",ClassName);
        classReal = classReal.replaceAll("@type@", paramName);
        classReal = classReal.replaceAll("@property@",name);
        classReal = classReal.replaceAll("@Uproperty@",upName);
        String fileName = ClassName+".java";
        try(FileWriter fw = new FileWriter("D:\\java file test\\"+fileName)){
            fw.write(classReal);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void deleteTag(File file){

        StringBuffer stringBuffer = new StringBuffer();
        try(BufferedReader bd = new BufferedReader(new FileReader(file))){
            while(true){
                String line = bd.readLine();
                if(line == null)break;
                if(!line.trim().startsWith("#"))
                    stringBuffer.append(line).append("\r\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try(PrintWriter br = new PrintWriter(new FileWriter(file,true))){
            br.print(stringBuffer);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }

    }

    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);

            for (byte b : bs) {
                int i = b&0xff;
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }

    public static void fileSub(File file){
        try{
            FileInputStream fis = new FileInputStream(file);
            byte[] txt = new byte[(int)file.length()];
            System.out.println(file.length());
            fis.read(txt);

            int number = (int)file.length()/100000000;
            for(int i = 0;i<number-1;i++) {
                File tempFile = new File(file.getParent() + "\\" + file.getName() + "_" + (i+1)+".mp4");
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(Arrays.copyOfRange(txt,i*100000000,(i+1)*100000000));
                fos.close();

            }
            File tempFile = new File(file.getParent() + "\\" + file.getName() + "_" + number+".mp4");
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(Arrays.copyOfRange(txt,(number-1)*100000000,txt.length));
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
