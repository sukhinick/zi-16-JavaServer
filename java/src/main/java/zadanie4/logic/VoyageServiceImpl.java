package zadanie4.logic;

import zadanie4.model.Voyage;
import zadanie4.model.VoyageType;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VoyageServiceImpl implements VoyageService {
    private final VoyageProvider provider = new VoyageProviderImpl();

    public VoyageServiceImpl() {
    }

    @Override
    public List<Voyage> getSortedBy(String field) {
        Collection<Voyage> voyages = provider.getAll();
        switch (field) {
            case "type":
                return voyages
                        .stream()
                        .sorted(Comparator.comparing(Voyage::getType))
                        .collect(Collectors.toList());
            case "duration":
                return voyages
                        .stream()
                        .sorted(Comparator.comparing(Voyage::getDuration))
                        .collect(Collectors.toList());
            case "mealIncluded":
                return voyages
                        .stream()
                        .sorted(Comparator.comparing(Voyage::getMealIncluded))
                        .collect(Collectors.toList());
            default:
                throw new RuntimeException("Никогда не было, и вот опять!");
        }
    }

    @Override
    public List<Voyage> filter(VoyageType type, Byte duration) {
        return provider.getAll()
                .stream()
                .filter(voyage -> voyage.getType().equals(type) && voyage.getDuration() >= duration)
                .collect(Collectors.toList());
    }
}
