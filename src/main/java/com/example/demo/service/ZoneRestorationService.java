import java.util.List;
import com.example.demo.entity.ZoneRestorationRecord;

public interface ZoneRestorationService {

    ZoneRestorationRecord saveRestoration(Long zoneId);

    ZoneRestorationRecord getRecordById(Long id);

    List<ZoneRestorationRecord> getRecordsForZone(Long zoneId);

    List<ZoneRestorationRecord> getAllRestorations();
}
