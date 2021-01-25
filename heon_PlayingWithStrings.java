import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayingWithStrings {
	public static void main(String[] args) {
		String filePath = "/Users/User/Downloads/images.csv";
		String line = "";
		// we're using an ArrayList here, as it's easier to read into an array list
		// as it can expand as needed [we assume we don't know how many
		// rows of data there are in images.csv
		List<String> rows = new ArrayList<String>(); 
		// the try block is what it says... it tries the following code 
		// but every try block must have it's catch(es) - i.e. code that will run
		// in case the runtime error happens (e.g. file does not exist ka... wrong IO type ka
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while((line = br.readLine()) != null) {
				rows.add(line); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // is what we'd normally put in there :)
			System.out.println("The file does not exist lah!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 'convert' the arraylist into an array
		String[] images = rows.toArray(new String[] {});
			
		//1.Display the image format for the third image file.
		
		System.out.println("1.Display the image format for the third image file");
		
			if(2<= images.length){                               
			    String thirdImage = images[2];
			    String format = thirdImage.substring(thirdImage.indexOf('.')+1);
			    System.out.println("The third file's image format is "+ format);
			    }

		//2.How many image formats are there in list? 	
			
		System.out.println("\n2.How many image formats are there in list?");
		
		String imgRef;
		String imgNext;
		
		List<String> foundFormat = new ArrayList<String>();
		
		int dotIndex = 0;
		for(int i=0 ; i<images.length ; i++) {
			dotIndex = images[i].indexOf(".");
			imgRef = images[i].substring(dotIndex+1);
			if(i==0) 
				foundFormat.add(imgRef);
			for (int j=i+1 ; j <images.length ; j++) {
				dotIndex = images[j].indexOf(".");
				imgNext = images[j].substring(dotIndex+1);
				if (imgRef.equals(imgNext) == false && foundFormat.contains(imgNext) == false ) {
					foundFormat.add(imgNext);
					
				}
			}		
			
		}		
		String[] allFoundFormat = foundFormat.toArray(new String[] {});
		System.out.println(Arrays.toString(allFoundFormat));
		int count = foundFormat.size();
		System.out.println("There are " + count + " image formats in the list.");
			
		//3.How many images are there for each format?
		
		System.out.println("\n3.How many images are there for each format?");
		
		int jpg = 0;
		int png = 0;
		int gif = 0;
		int bmp = 0;
		int tiff = 0;
		
		for(int i= 0; i < images.length ; i++) {
			String data = images[i];
			String format = data.substring(data.indexOf('.')+1);
			
			if(format.equals("jpg")) {
				jpg += 1 ;
				}
			else if (format.equals("png")) {
				png += 1 ;
				}
			else if (format.equals("gif")) {
				gif += 1 ;
				}
			else if (format.equals("bmp")) {
				bmp += 1 ;
				}
			else if (format.equals("tiff")) {
				tiff += 1 ;
			}
			else {}
			
		}
			System.out.println("There are "+ jpg + " jpg images.");
			System.out.println("There are "+ png + " png images.");
			System.out.println("There are "+ gif + " gif images.");
			System.out.println("There are "+ bmp + " bmp images.");
			System.out.println("There are "+ tiff + " tiff images.");
			
			//4.Mr. Caspian changed his name to Robert. Replace all occurrences of his previous name with his news name
			
			System.out.println("\n4.Mr. Caspian changed his name to Robert. Replace all occurrences of his previous name with his news name.");
					
			List<String> name = new ArrayList<String>();
			name.add("caspian");
			
			for (int i= 0; i < images.length; i++) {
				String data = images[i];
				String oldName = data.substring(0,7);
				
			if (name.contains(oldName)) {
				System.out.println("[Previous file name] - " + data);
				data = data.replace("caspian", "robert");
				System.out.println("[New file name] - " + data);
			}
			else {}
			}
		
	}
}
