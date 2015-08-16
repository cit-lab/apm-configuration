package cn.edu.sjtu.cit.apm.configuration.collection;

import cn.edu.sjtu.cit.apm.configuration.entity.BaseConfigEntity;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Pillar on 2015/8/16.
 */
public abstract class BaseConfigCollection<T extends BaseConfigEntity> {
    protected List<T> configs;

    public BaseConfigCollection(){
        configs = new ArrayList<T>();
    }

    public List<T> getAll(){
        return configs;
    }

    protected void read(String fileName, String nodeName) throws ConfigurationException{
       read(new XMLConfiguration(fileName).configurationsAt(nodeName));
    }

    protected void read(List<HierarchicalConfiguration> configurations){
        // clean the list
        configs = new ArrayList<T>();
        for (Iterator it = configurations.iterator(); it.hasNext(); ) {
            HierarchicalConfiguration configuration = (HierarchicalConfiguration) it.next();
            configs.add(createConfig(configuration));
        }
    }

    public abstract T createConfig(HierarchicalConfiguration configuration);

    @Override public String toString(){
        // loop and show everyone
        String str = "\nprinting: " + super.toString() + "\n";
        for(Iterator it = configs.iterator();it.hasNext();){
            str += it.next().toString() + "\n";
        }
        str += "printing end for collection " + this.getClass() + "\n";
        return  str;
    }
}
