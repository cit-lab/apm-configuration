package cn.edu.sjtu.cit.apm.configuration.entity;

import cn.edu.sjtu.cit.apm.configuration.InvalidConfigException;
import lombok.Getter;
import org.apache.commons.configuration.HierarchicalConfiguration;

/**
 * Created by Pillar on 2015/8/16.
 */
public class ConnectionConfigEntity extends BaseConfigEntity{
    @Getter
    protected String srcInstanceName;
    @Getter
    protected String dstInstanceName;

    public ConnectionConfigEntity(HierarchicalConfiguration configuration){
        super(configuration);
    }

    // FIXME: should throw exception if src and dst is null.but since
    @Override public void readConfig(){
        srcInstanceName = configuration.getString("[@src]");
        dstInstanceName = configuration.getString("[@dst]");
        name = srcInstanceName + '-' + dstInstanceName;
    }

    @Override public String toString(){
        return super.toString() + ",src=" + getSrcInstanceName() + ",dst=" + getDstInstanceName();
    }
}
