package cn.edu.sjtu.cit.apm.configuration.entity;

import lombok.ToString;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ApplicationConfigEntity extends BaseConfigEntity {
    public ApplicationConfigEntity(HierarchicalConfiguration configuration){
        super(configuration);
    }

    @Override public void readConfig(){
        this.name = configuration.getString("name");
    }
}
