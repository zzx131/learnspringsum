package com.zzx.collection.resource;

import io.loadkit.Loaders;
import io.loadkit.Resource;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ResourseTest {

    @Test
    public void testResource() throws IOException {
        Enumeration<Resource> license = Loaders.std().load("license",
                true, (name, url) -> name.endsWith(".lic"));

        while (license.hasMoreElements()) {
            URL url = license.nextElement().getUrl();
            System.out.println(url.getPath());
        }

    }
}
