<%@page import="java.io.OutputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<%
		//响应头
		// 设置输出格式
		response.setContentType("image/jpeg");

		// 图片的宽度
		int width = 100;
		// 图片的高度
		int height = 25;
		// 图片中的内容 4个字符
		char[] code = new char[4];
		// 存储随机产生的4个字符
		String arr = "123456789piuytrewqasdfghjklmnbvcxzQWERTYUIPLKJHGFDSAZXCVBNM";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			code[i] = arr.charAt(random.nextInt(arr.length()));
		}


		// 在内存中生成一张图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获得这张图片的画笔(句柄)
		Graphics g = image.getGraphics();
		// 设置画笔的颜色
		g.setColor(Color.white);
		// 给图片绘制背景色
		g.fillRect(0, 0, width, height);
		
		// 在图片上写入文字
		// 设置字体和颜色
		g.setFont(new Font("宋体",Font.BOLD,22));
		g.setColor(Color.black);
		for(int i=0;i<code.length;i++){
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			g.drawString(Character.toString(code[i]),25*i+3,20 );
		}
		// 添加干扰线
		for(int i=0;i<code.length;i++){
			g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
			g.drawLine(new Random().nextInt(width), new Random().nextInt(height), new Random().nextInt(width), new Random().nextInt(height));
		}
		// 释放
		g.dispose();
		// 图片写入到响应流
		OutputStream os=response.getOutputStream();
		ImageIO.write(image, "JPEG",os);
		os.flush();
		os.close();
		os=null;
		response.flushBuffer();
		out.clear();
		out = pageContext.pushBody();
		// 保存生成的验证码，以便后续业务验证(注意,验证后，请清除这个session)
		//req.setAttribute("code", String.valueOf(code));
		request.getSession().setAttribute("code", String.valueOf(code));
%>
</body>
</html>