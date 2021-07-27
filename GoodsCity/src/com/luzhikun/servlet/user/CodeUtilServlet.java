package com.luzhikun.servlet.user;

import com.luzhikun.util.CodeUtil;
import com.luzhikun.util.CodeUtil2;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CodeUtilServlet",value = "/codeUtilServlet")
public class CodeUtilServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 通过工具类调用获取图片Map集合
        Map codeutil = CodeUtil2.getCodeutil();
        ServletOutputStream out= null;

        try {
            // 创建输出流
            out = response.getOutputStream();
            // 将图片写出去
            ImageIO.write((RenderedImage) codeutil.get("img"),"jpg",out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            out.close();
        }


    }
}
