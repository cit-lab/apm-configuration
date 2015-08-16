package cn.edu.sjtu.cit.apm.configuration.entity;

import cn.edu.sjtu.cit.apm.configuration.collection.ApplicationConfigCollection;
import cn.edu.sjtu.cit.apm.configuration.collection.ApplicationWithInstanceConfigCollection;
import cn.edu.sjtu.cit.apm.configuration.collection.ConnectionConfigCollection;
import lombok.Getter;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class GroupConfigEntity extends BaseConfigEntity {
    @Getter
    protected ApplicationWithInstanceConfigCollection applications;
    @Getter
    protected ConnectionConfigCollection connections;

    public GroupConfigEntity(HierarchicalConfiguration configuration){
        super(configuration);
    }

    @Override public void readConfig(){
        this.name = configuration.getString("name");
        this.applications = new ApplicationWithInstanceConfigCollection(configuration.configurationsAt("applications.application"));
        this.connections = new ConnectionConfigCollection(configuration.configurationsAt("connections.connection"));
    }

    @Override public String toString(){
        return super.toString() +
                "\n applications are \n" + applications +
                "\n connections are \n" + connections;
    }
}
