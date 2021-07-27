package com.luzhikun.servlet.product;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.luzhikun.dao.IProductDao;
import com.luzhikun.domain.Goods_Product;
import com.luzhikun.service.IProductService;
import com.luzhikun.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * @Author liu-miss
 * @Description 商品添加
 * @Date 19:43 2021/5/31
 **/
@WebServlet(name = "DoProductAddServlet",value = "/manager/admin_doProductAddServlet")
public class DoProductAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建文件上传对象
        SmartUpload sLoad=new SmartUpload();

        // 初始化文件上传对象
        sLoad.initialize(this.getServletConfig(),request,response);

        // 上传过程
        try {
            sLoad.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        // 获取所有的文件上传对象
        Files files = sLoad.getFiles();
        // 获取上传的第一个文件
        com.jspsmart.upload.File file = files.getFile(0);
        // 获取上传文件的文件名
        String fileName = file.getFileName();
        System.out.println(fileName);
        // 保存的位置
        try {
            String realPath = this.getServletContext().getRealPath("/img/temp");
            System.out.println(realPath);
            sLoad.save(realPath);
            System.out.println("上传成功");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request1 = sLoad.getRequest();

        // 获取到前台传来的数据
        String productName= request1.getParameter("productName");
        String productId = request1.getParameter("parentId");
        String productPrice = request1.getParameter("productPrice");
        String productDesc = request1.getParameter("productdesc");
        String productStock = request1.getParameter("productStock");
        System.out.println(productName);
        System.out.println(productDesc);
        // 生成javaBean对象
        Goods_Product goods_product=new Goods_Product(
                0,
                productName,
                productDesc,
                Integer.parseInt(productPrice),
                Integer.parseInt(productStock),
                Integer.parseInt(productId.split("-")[0]),
                Integer.parseInt(productId.split("-")[1]),
                fileName
        );
        // 插入到数据库
        IProductService ips=new ProductServiceImpl();
        boolean b = ips.insertProduct(goods_product);
        System.out.println(b);
        // 成功或者失败重定向到哪里
        if (b){     
            response.sendRedirect(request.getContextPath()+"/manager/productServlet");
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('商品添加失败')");
            out.write("location.href='/manager/admin_toProductAdd'");
            out.write("</script>");
        }


    }

}
