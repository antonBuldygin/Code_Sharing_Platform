package platform;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Service {
    String newCode (Code code, String data);

    List<Code> latest();

    Code findByUuId(String id);

    void delete();

}