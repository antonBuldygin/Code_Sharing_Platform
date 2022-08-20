package platform;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    private final CodeRepository codeRepository;

    @Autowired
    public ServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    private Map<Long, Code> CODEREPOSITORY = new TreeMap<>();

    private static AtomicInteger CODE_ID = new AtomicInteger(20);

    @Override
    public String newCode(Code code, String date) {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        Long id = (long) CODE_ID.getAndIncrement();
        code.setUuId(randomUUIDString);
        code.setDate(date);
        code.setTimeConstant(code.getTime());
        if (code.getTime() > 0 && code.getViews() > 0) {
            code.setLogic(true);
        }

        if (code.getTime() > 0) {
            code.setTimeR(true);
        }

        if (code.getViews() > 0) {
            code.setViewsR(true);
        }

        Code codeSaved = codeRepository.save(code);
        return codeSaved.getUuId();
    }

    public String updateCode(Code code) {

        Code codeSaved = codeRepository.save(code);
        return String.valueOf(codeSaved.getId());
    }

    @Override
    public List<Code> latest() {
        List<Code> listOfCode = new ArrayList<>();

        List<Code> codeList = new ArrayList<>();

        Iterable<Code> iterable = codeRepository.findAll();
        iterable.forEach(codeList::add);
        int count = 0;

        for (int i = codeList.size() - 1; i >= 0; i--) {

            if (count <= 9
                    && (!codeList.get(i).getTimeR() && !codeList.get(i).getViewsR())) {
//                Map<String, String> map = new TreeMap<>(Map.of("code", codeList.get(i).getCode(),
//                        "date", codeList.get(i).getDate(), "time", String.valueOf(codeList.get(i).getTime()),
//                        "views", String.valueOf(codeList.get(i).getViews())));
                listOfCode.add(codeList.get(i));
                count++;
            } else {
                continue;
            }
        }

        return listOfCode;
    }

    @Override
    public Code findByUuId(String id) {

        Code n = codeRepository.findCodeByUuId(id);
        return n;
    }

    @Override
    public void delete() {
        codeRepository.deleteAll();
    }

    public List<Long> getAll() {
        Iterable<Code> iterable = codeRepository.findAll();
        List<Long> longList = new ArrayList<>();
        for (Code item : iterable
        ) {
            longList.add(item.getId());
        }
        return longList;
    }
}