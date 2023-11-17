package Creatures;


interface CreatureActions {
	void eat();
	void makeSound();
	void heal();
	void sleep();
	void wakeUp();
	void age();
}


enum AgeCategory {
	YOUNG, ADULT, OLD, DEAD
}

enum SpeciesName {
	DRAGONS, KRAKENS, LICORNES, LYCANTHROPES, MEGALODONS, NYMPHES, PHENIX, SIRENES
}


abstract class Creatures implements CreatureActions {

	protected String speciesName;
	protected char gender;
	protected double weight;
	protected double size;

	protected int age;
	private AgeCategory ageCategory;

	protected int hungerIndicator;
	protected boolean isHungry;

	protected int sleepIndicator;
	protected boolean isSleeping;

	protected int healthIndicator;
	private boolean isSick;

	
	int Phase = 1;
	

	public Creatures(String speciesName) {
		this.speciesName = speciesName;
		this.age = 0;
		this.isSick = false;
		this.ageCategory = AgeCategory.YOUNG;
	}


	public String getSpeciesName() {
		return speciesName;
	}


	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getSize() {
		return size;
	}


	public void setSize(double size) {
		this.size = size;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public AgeCategory getAgeCategory() {
		return ageCategory;
	}


	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}


	public int getHungerIndicator() {
		return hungerIndicator;
	}


	public void setHungerIndicator(int hungerIndicator) {
		this.hungerIndicator = hungerIndicator;
	}


	public boolean isHungry() {
		return isHungry;
	}


	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}


	public int getSleepIndicator() {
		return sleepIndicator;
	}


	public void setSleepIndicator(int sleepIndicator) {
		this.sleepIndicator = sleepIndicator;
	}


	public boolean isSleeping() {
		return isSleeping;
	}


	public void setIsSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}


	public int getHealthIndicator() {
		return healthIndicator;
	}


	public void setHealthIndicator(int health) {
		this.healthIndicator = health;
		if(healthIndicator<=3)
			setIsSick(true);
		else if(healthIndicator==0)
			setAgeCategory(ageCategory.DEAD);
	}	


	public boolean isSick() {
		return isSick;
	}


	public void setIsSick(boolean isSick) {
		this.isSick = isSick;
	}


	public void eat() {
		if (!isSick||!isSleeping)
			System.out.println(speciesName + " mange.");
		else if(isSick)
			System.out.println(speciesName + " est malade et ne peut pas manger.");
		else if(isSleeping)
			System.out.println(speciesName + " dort et ne peut pas manger.");
		setHungerIndicator(10);
	}


	@Override
	public void makeSound() {
		System.out.println(speciesName + " émet un son.");
	}


	@Override
	public void heal() {
		System.out.println(speciesName + " a été soigné.");
		setIsSick(false);
		setHealthIndicator(10);
	}


	@Override
	public void sleep() {
		System.out.println(speciesName + " s'endort.");
		setIsSleeping(true);
		setSleepIndicator(10);
	}


	@Override
	public void wakeUp() {
		System.out.println(speciesName + " se réveille.");
		setIsSleeping(false);
	}


	@Override
	public void age() {
		if (ageCategory != AgeCategory.DEAD) {
			age++;
			try {
				SpeciesName species = SpeciesName.valueOf(speciesName.toUpperCase());
				//Dragons : 0-99=young 100-799=adult 800-1249=old 1250=dead
				if(species == SpeciesName.DRAGONS) {
					if(age < 100) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 100 && age < 800) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 800 && age < 1250) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 1250) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Krakens : 0-49=young 50-299=adult 300-599=old 600=dead
				else if(species == SpeciesName.KRAKENS) {
					if(age < 50) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 50 && age < 300) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 300 && age < 600) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 600) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Licornes : 0-19=young 20-149=adult 150-299=old 300=dead
				else if(species == SpeciesName.LICORNES) {
					if(age < 20) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 20 && age < 150) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 150 && age < 300) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 300) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Lycanthropes : 0-29=young 30-149=adult 150-299=old 300=dead
				else if(species == SpeciesName.LYCANTHROPES) {
					if(age < 30) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 30 && age < 150) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 150 && age < 300) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 300) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Megalodons : 0-19=young 20-99=adult 100-199=old 200=dead
				else if(species == SpeciesName.MEGALODONS) {
					if(age < 20) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 20 && age < 100) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 100 && age < 200) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 200) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Nymphes : 0-99=young 100-499=adult 500-999=old 1000=dead
				else if(species == SpeciesName.NYMPHES) {
					if(age < 100) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 100 && age < 500) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 500 && age < 1000) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 1000) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Phenix : 0-99=young 100-299=adult 300-499=old 500=renaissance si fin 3ème phase=dead
				else if(species == SpeciesName.PHENIX) {
					if(age < 100) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 100 && age < 300) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 300 && age < 500) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 500 && Phase <3) {
						this.age=1;
						Phase++;
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 500 && Phase == 3) {
						ageCategory = AgeCategory.DEAD;
					}
				}
				//Sirenes : 0-99=young 100-299=adult 300-499=old 500=dead
				else if(species == SpeciesName.SIRENES) {
					if(age < 100) {
						ageCategory = AgeCategory.YOUNG;
					}
					else if(age >= 100 && age < 300) {
						ageCategory = AgeCategory.ADULT;
					}
					else if(age >= 300 && age < 500) {
						ageCategory = AgeCategory.OLD;
					}
					else if(age >= 500) {
						ageCategory = AgeCategory.DEAD;
					}
				}
			}
			catch (IllegalArgumentException e) {
				// La chaîne ne correspond pas à une valeur de l'énumération SpeciesName
				System.err.println("Nom d'espèce erroné !");
			}
		}
	}
}
