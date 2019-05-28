package zadanie4.logic;

import zadanie4.model.Voyage;
import zadanie4.model.VoyageType;

import java.util.List;

public interface VoyageService {
    List<Voyage> getSortedBy(String field);

    List<Voyage> filter(VoyageType type, Byte duration);
}
