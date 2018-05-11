package ru.job4j.professions;

public class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        return Diagnose.EMPTY;
    }

}
