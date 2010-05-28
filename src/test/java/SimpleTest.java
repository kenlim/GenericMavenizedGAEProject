import namespace.models.ElGenerico;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleTest {
    @Test
    public void shouldCreateModelObject() {
        assertThat(1 + 1, equalTo(2));
    }
}
