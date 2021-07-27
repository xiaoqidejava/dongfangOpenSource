package com.luzhikun.util;

import sun.java2d.loops.GraphicsPrimitiveMgr;
import sun.java2d.pipe.DrawImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
public class CodeUtil2 {

    // 颜色数组
    private final static Color[] color={Color.red,Color.yellow,Color.black,Color.green,Color.pink,Color.BLUE};
    // 字符数组
    private final static String[] code={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","","","","","","",""
    ,"2","3","4","5","6","7","8","9","a","b","q","w","e","r","t","y","u","i","o","p","s","d","f","g","h","j","k","l","z","x","c","v","m","n"};
    // 字体数组
    private final static String[] charset={"黑体","楷体","微软雅黑"};
    // 字体高度
    private final  static int fontHeight=30;
    // 设置宽高
    private final static int height=35;
    private final static int weight= 200;

    public static Map getCodeutil(){

        Map map=new HashMap();
        // 创建一个内存图片
        BufferedImage bu =new BufferedImage(weight,height,BufferedImage.TYPE_INT_RGB);
        // 创建一个 随机数
        Random random=new Random();
        // 创建一个画笔
        Graphics grcs=bu.getGraphics();
        // 将图片填充为灰色
        grcs.setColor(Color.gray);
        // 将图片填充到组件中
        grcs.fillRect(0,0,weight,height);

        // 创建字体
        Font font=new Font(charset[random.nextInt(charset.length)],Font.BOLD,fontHeight);
        // 设置字体
        grcs.setFont(font);

        // 画边框。
        grcs.setColor(Color.BLACK);
        grcs.drawRect(1, 1, weight - 2, height - 2);
        // 设置线的颜色为灰色
        grcs.setColor(Color.yellow);
        // 随机生成10条阻碍线
        for (int i = 0; i <300; i++) {
            grcs.drawLine(random.nextInt(weight),random.nextInt(height),random.nextInt(weight),random.nextInt(height));
        }

        int x=35;
        // 画4个验证码
        for (int i = 0; i < 4; i++) {
            // 设置字体颜色
            Color colors=color[random.nextInt(color.length)];
            grcs.setColor(colors);
            // 获取验证码
            grcs.drawString(code[random.nextInt(code.length)],x,25);
            x+=35;
        }
        map.put("img",bu);
        return map;
    }

}
