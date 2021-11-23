package br.com.resistence.network.util;

import br.com.resistence.network.entity.Inventory;
import br.com.resistence.network.entity.Localization;
import br.com.resistence.network.entity.Rebel;
import br.com.resistence.network.model.Genre;
import br.com.resistence.network.model.InventoryType;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FakerGenerator {

    private FakeValuesService service;
    private Faker fake;

    public FakerGenerator() {
        service = new FakeValuesService(new Locale("pt-BR"), new RandomService());
        fake = new Faker();
    }

    public List<Rebel> generateRandomBlackForce(int quantity) {
        List<Rebel> rebels = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            rebels.add(generateRebel(true));
        }
        return rebels;
    }

    public List<Rebel> generateRandomRebel(int quantity) {
        List<Rebel> rebels = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            rebels.add(generateRebel(false));
        }
        return rebels;
    }

    public List<Inventory> randomInventory(int quantity, long rebelId) {
        List<Inventory> inventories = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            inventories.add(generateRandomInventory(rebelId));
        }
        return inventories;
    }

    public Rebel generateRebel(boolean isBlackForce, Inventory...inventory) {

        Rebel rebel = new Rebel();

        rebel.setId(fake.number().randomNumber());
        rebel.setAge(fake.random().nextInt(10, 50));
        rebel.setGenre(fake.random().nextInt(0, 1) == 0 ? Genre.MALE : Genre.FEMALE);
        rebel.setName(fake.artist().name());
        rebel.setBlackForceReport(isBlackForce ? fake.random().nextInt(3, 6) : fake.random().nextInt(0, 2));

        Localization localization = new Localization();
        localization.setLongitude(service.regexify("[a-z1-9]{10}"));
        localization.setLatitude(service.regexify("[a-z1-9]{10}"));
        localization.setGalaxyName(fake.space().galaxy());
        localization.setId(fake.number().randomNumber());

        rebel.setLocalization(localization);

        rebel.setInventories(Arrays.asList(inventory));
        return rebel;
    }

    private Inventory generateRandomInventory(Long rebelId) {

        Rebel rebel = new Rebel();
        rebel.setId(rebelId);

        Inventory inventory = new Inventory();
        inventory.setInventoryType(randomizeInventoryType(fake.random().nextInt(0, 3)));
        inventory.setId(fake.number().randomNumber());
        inventory.setQuantity(fake.number().numberBetween(1, 5));

        return inventory;
    }

    private InventoryType randomizeInventoryType(int id) {

        switch (id) {
            case 0: return InventoryType.GUN;
            case 1: return InventoryType.FOOD;
            case 2: return InventoryType.BULLETS;
            case 3: return InventoryType.WATER;
        }

        return InventoryType.FOOD;
    }
}
