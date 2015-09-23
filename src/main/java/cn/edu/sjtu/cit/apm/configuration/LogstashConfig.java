package cn.edu.sjtu.cit.apm.configuration;

/**
 * Created by gpl on 15/9/21.
 */

import java.io.*;
import java.util.HashMap;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.configuration.PropertiesConfiguration;


/**
 * Created by gpl on 15/9/20.
 */
public class LogstashConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogstashConfig.class);

    private String confPath;
    private String logstashConfPath;
    private String templatePath;
    private String redisHost;
    private String elasticSearchHost;
    private Integer elasticSearchHttpPort;

    public LogstashConfig(String confPath) {
        this.confPath = confPath;
    }

    protected void removeOld() {
        File oldConf = new File(logstashConfPath);
        if (oldConf.isFile() && oldConf.exists()) {
            oldConf.delete();
        }
    }

    protected void readConfig() throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration(confPath);
        logstashConfPath = config.getString("logstash.conf.path");
        templatePath = config.getString("logstash.conf.template");
        redisHost = config.getString("logstash.redis.host");
        elasticSearchHost = config.getString("logstash.elasticsearch.host");
        elasticSearchHttpPort = config.getInt("logstash.elasticsearch.http-port");
        LOGGER.debug("host is " + elasticSearchHost);
        LOGGER.debug("http port is " + elasticSearchHttpPort);
    }

    public void renderAndWrite() throws IOException, ConfigurationException {
        readConfig();
        removeOld();

        InputStreamReader reader;
        BufferedReader bufferedReader;
        File template = new File(templatePath);
        if (!template.isFile() || !template.exists()) {
            LOGGER.error("template for logstash config doesn't exist! ");
            throw new IOException("template for logstash config doesn't exist! ");
        }
        reader = new InputStreamReader(new FileInputStream(template));
        bufferedReader = new BufferedReader(reader);

        File newConf = new File(logstashConfPath);
        Writer writer = new OutputStreamWriter(new FileOutputStream(newConf));
        HashMap<String, Object> m = new HashMap<String, Object>();


        // Add redis host
        m.put("redisHost", redisHost);
        m.put("elasticSearchHost", elasticSearchHost);
        m.put("elasticSearchHttpPort", elasticSearchHttpPort);

        MustacheFactory mf = new DefaultMustacheFactory();
        // TODO: what's the meaning of this tag in mustache's compile
        Mustache mustache = mf.compile(bufferedReader, "example");
        mustache.execute(writer, m);
        writer.flush();

        bufferedReader.close();
        reader.close();
    }
}