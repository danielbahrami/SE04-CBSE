package dk.sdu.mmmi.cbse.core.managers;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxNativesLoader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;

public class AssetsJarFileResolverTest {
    public AssetsJarFileResolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Gdx.app = mock(Application.class);
        Gdx.gl = mock(GL20.class);
        GdxNativesLoader.load();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testJarAssetManager() throws MalformedURLException {
        System.out.println("testJarAssetManager");
        String jarUrl = java.nio.file.Paths.get(new File("").getAbsolutePath(),
                "target", "Core-1.0-SNAPSHOT.jar!", "assets", "images", "Ship.png").toString();
        AssetsJarFileResolver jfhr = new AssetsJarFileResolver();
        AssetManager am = new AssetManager(jfhr);
        am.load(jarUrl, Texture.class);
        am.finishLoading();
        Texture result = am.get(jarUrl, Texture.class);
        assertNotNull(result.getTextureData());
    }
}
