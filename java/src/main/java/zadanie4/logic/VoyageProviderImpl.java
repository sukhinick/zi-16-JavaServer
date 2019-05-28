package zadanie4.logic;

import zadanie4.model.TransportType;
import zadanie4.model.Voyage;
import zadanie4.model.VoyageType;

import java.util.*;

public class VoyageProviderImpl implements VoyageProvider {
    private final Set<Voyage> voyages = new HashSet<>(Arrays.asList(
            new Voyage(VoyageType.REST, TransportType.AIRPLANE, (byte) 4, true),
            new Voyage(VoyageType.EXCURSION, TransportType.BUS, (byte) 2, false),
            new Voyage(VoyageType.CRUISE, TransportType.TRAIN, (byte) 5, true),
            new Voyage(VoyageType.HEALING, TransportType.BUS, (byte) 14, true),
            new Voyage(VoyageType.SHOPPING, TransportType.BUS, (byte) 1, false),
            new Voyage(VoyageType.REST, TransportType.TRAIN, (byte) 7, true)
    ));

    @Override
    public Collection<Voyage> getAll() {
        return Collections.unmodifiableCollection(voyages);
    }
}
