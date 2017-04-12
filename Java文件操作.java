//java实现读取、删除文件夹下的文件
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile{
	public ReadFile(){
	}
}
public static boolean readfile(String filepath) throws FileNotFoundException，IOException{
	try{
		File file = new File(filepath);
		if(!file.isDirectory()){
			System.out.println(file.getName());
			file.delete();
		}else if(file.isDirectory()){
			String[] filelist = file.list();
			for(int i = 0; i < filelist.length; i++){
				File readfile = new File(filepath + "\\" + filelist[i]);
				if(!readfile.isDirectory())
					System.out.println(readfile.getName());
				else readfile(filepath + "\\" + filelist[i]);
				/*
				File[] filelist = file.listFiles();
            for (int i = 0; i < filelist.length; i++) {
                temp = filelist[i];
                if (temp.getName().endsWith("apk") && !temp.getName().endsWith(name))// 获得文件名，如果后缀为“”，这个你自己写，就删除文件
                {
                    temp.delete();// 删除文件}
                }
				 */
			}
		}
	}catch(FilkeNotFoundException e){

	}
}