package Animal;



import java.util.Random;

public class PetShop {
    private String name;
    private double rest;


    private Pet[] pets = new Pet[8];
    private int count = 0;

    public PetShop(String name, double rest) {
        this.name = name;
        this.rest = rest;
        addPet(new Dog("小黑", "公", 2, 100, true));
        addPet(new Cat("莉莉", "母", 4, 200));
        addPet(new Dog("小白", "公", 1, 100, false));
        addPet(new Cat("露西", "母", 6, 200));
        addPet(new Dog("安迪", "公", 1, 100, false));
        addPet(new Cat("默默", "母", 2, 200));
        addPet(new Cat("小强", "公", 8, 200));

    }

    public boolean hasDogName(String name) {
        for (Pet pet : pets) {
            if (pet instanceof Dog) {
                Dog d = (Dog) pet;
                boolean equals = d.getName().equals(name);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCatName(String name) {
        for (Pet pet : pets) {
            if (pet instanceof Cat) {
                Cat c = (Cat) pet;
                boolean equals = c.getName().equals(name);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getRest() {
        return rest;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public int size() {
        return count;
    }


    private boolean addPet(Pet pet) {
        if (count >= pets.length) {
            return false;
        }
        pets[count] = pet;
        count++;

        return true;


    }


    public boolean purchasePet(Pet pet) {
        rest = rest - pet.price;
        return this.addPet(pet);
    }

    public Pet buyDog(String name) {
        int nameNum = 0;
        for (int i = 0; i < pets.length; i++) {
            Pet pet = pets[i];
            if (pet instanceof Dog) {
                Dog d = (Dog) pet;
                boolean equals = d.getName().equals(name);
                if (equals) {
                    nameNum++;
                    rest = rest + 100;
                }
            }
        }
        int[] nameIndex = new int[nameNum];
        int k = 0;
        for (int i = 0; i < pets.length; i++) {
            Pet pet = pets[i];
            if (pet instanceof Dog) {
                Dog d = (Dog) pet;
                boolean equals = d.getName().equals(name);
                if (equals) {
                    nameIndex[k++] = i;
                }
            }
        }
        Random r = new Random();
        int nextInt = r.nextInt(nameIndex.length);
        int i = nameIndex[nextInt];

        Pet result = pets[i];
        capaticyConfirm(i);
        return result;
    }

    private void capaticyConfirm(int index) {
        // 5 6
        int tag = index;
        while (tag < count - 1) {
            pets[tag] = pets[tag + 1];
            tag++;
        }
        pets[--count] = null;
    }


    public void showPets() {
        for (int i = 0; i < count; i++) {
            pets[i].show();
        }
    }

    public Pet buyCat(String name) {
        int nameNum = 0;
        for (int i = 0; i < pets.length; i++) {
            Pet pet = pets[i];
            if (pet instanceof Cat) {
                Cat c = (Cat) pet;
                boolean equals = c.getName().equals(name);
                if (equals) {
                    nameNum++;
                    rest = rest + 200;
                }
            }
        }
        int[] nameIndex = new int[nameNum];
        int a = 0;
        for (int i = 0; i < pets.length; i++) {
            Pet pet = pets[i];
            if (pet instanceof Cat) {
                Cat c = (Cat) pet;
                boolean equals = c.getName().equals(name);
                if (equals) {
                    nameIndex[a++] = i;
                }
            }
        }
        Random r = new Random();
        int nextInt = r.nextInt(nameIndex.length);
        int i = nameIndex[nextInt];

        Pet result = pets[i];
        capaticyConfirm(i);
        return result;
    }

}

