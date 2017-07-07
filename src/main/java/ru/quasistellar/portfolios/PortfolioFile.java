package ru.quasistellar.portfolios;

import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class PortfolioFile {
    private static final String DIR = "src/main/resources/static/img/portfolio/";
    public boolean loadFile(MultipartFile file) {
        if (!(file.isEmpty())) {
            String name = file.getOriginalFilename();
            File f = new File(DIR,name);
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(f));
                stream.write(bytes);
                stream.close();


            } catch (Exception e) {
                return false;
            }
        } else{
            return false;
        }
        return true;
    }
}
