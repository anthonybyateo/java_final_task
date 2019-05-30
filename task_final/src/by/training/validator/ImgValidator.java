package by.training.validator;

import by.training.entity.Img;
import by.training.exception.IncorrectFormDataException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Objects;

public class ImgValidator implements Validator<Img> {
    private static final String FILE = "file";

    @Override
    public Img validate(HttpServletRequest request) throws
            IOException, ServletException, IncorrectFormDataException {

        Img image = new Img();

        Part part = request.getPart(FILE);
        String fileName = transferTo(part, request);
        if(fileName != null && !fileName.isEmpty()) {
            image.setFilePath("img/" + fileName);
        } else {
            throw new IncorrectFormDataException(FILE, fileName);
        }

        return image;
    }

    private String transferTo(final Part part,
                              final HttpServletRequest request)
            throws IOException {
        String fileName= Paths.get(
                part.getSubmittedFileName()).getFileName().toString();
        String absolutePath = request.getServletContext().getRealPath("");
        String[] strings = absolutePath.split("\\\\");
        StringBuilder builder = new StringBuilder();
        for (int  i = 0; i < strings.length - 3; i++) {
            builder.append(strings[i]);
            builder.append("/");
        }

        String newFilePath = absolutePath + "img/" + fileName;

        InputStream inputStream = part.getInputStream();
        OutputStream outputStream = new FileOutputStream(newFilePath);
        Objects.requireNonNull(outputStream, "out");
        byte[] buffer = new byte[8192];
        int read;
        while ((read = inputStream.read(buffer, 0, 8192)) >= 0) {
            outputStream.write(buffer, 0, read);
        }
        inputStream.close();
        outputStream.close();
        return fileName;
    }
}
