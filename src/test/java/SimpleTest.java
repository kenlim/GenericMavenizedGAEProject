import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SimpleTest {
    @Test
    public void shouldCreateModelObject() {
        assertThat(1 + 1, equalTo(2));
    }
}
