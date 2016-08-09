/**
 * 
 */
package com.iam_vip.jsoup_all.velocity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.iam_vip.jsoup_all.torrent.AVTorrent;
import com.iam_vip.jsoup_all.torrent.AVTorrent.OnFinishFetch;

/**
 * @author Colin
 */
public class JsoupToHtmlTemplate implements OnFinishFetch {

	static final String TEMPLATE_VM = "com/iam_vip/jsoup_all/velocity/template.vm";

	public JsoupToHtmlTemplate(String folder) throws Exception {
		String tempDir = folder == null || "".equals(folder) ? System.getProperty("java.io.tmpdir") : folder;
		Properties properties = new Properties();
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempDir);
		Velocity.init(properties);
	}

	public JsoupToHtmlTemplate() throws Exception {
		this(null);
	}

	public String resource2temp(String res) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(res);

		File tmp = File.createTempFile("template", ".vm");
		FileOutputStream outputStream = new FileOutputStream(tmp);

		byte[] buf = new byte[1024 * 100];
		int len = 0;
		while ((len = inputStream.read(buf)) > 0) {
			outputStream.write(buf, 0, len);
		}
		inputStream.close();
		outputStream.close();

		return tmp.getName();
	}

	public void outputTemplate(VelocityContext context, String folder, String file) throws IOException, ResourceNotFoundException, ParseErrorException, Exception, MethodInvocationException {
		this.outputTemplate(TEMPLATE_VM, context, folder, file);
	}

	public void outputTemplate(String res, VelocityContext context, String folder, String file) throws IOException, ResourceNotFoundException, ParseErrorException, Exception, MethodInvocationException {
		String templatePath = this.resource2temp(res);
		Template template = Velocity.getTemplate(templatePath, "UTF-8");

		File toFile = new File(folder, file);
		FileWriter writer = new FileWriter(toFile);
		template.merge(context, writer);
		writer.close();
	}





	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {


		String url = "";

		AVTorrent tv = new AVTorrent();
		tv.toHtml(url, new JsoupToHtmlTemplate());


	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.iam_vip.jsoup_all.torrent.AVTorrent.OnFinishFetch#fetch(java.util.
	 * Map)
	 */
	@Override
	public void fetch(Map<String, String> maps) {


		String folder = "E:\\tmp", file = "output.json.html";

		VelocityContext context = new VelocityContext();

		context.put("maps", maps);

		try {
			this.outputTemplate(context, folder, file);
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}





}
