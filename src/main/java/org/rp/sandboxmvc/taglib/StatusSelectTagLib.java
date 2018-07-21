package org.rp.sandboxmvc.taglib;

import org.rp.sandboxmvc.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

@ComponentScan
public class StatusSelectTagLib extends SimpleTagSupport {

    @Autowired
    private ChannelService channelService;

    @Override
    public void doTag() throws IOException {
        final JspWriter writer = getJspContext().getOut();
        writer.print("STATUS WILL BE HERE " + channelService);
    }

}
