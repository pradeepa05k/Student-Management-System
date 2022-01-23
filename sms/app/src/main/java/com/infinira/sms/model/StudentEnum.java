package com.infinira.sms.model;

public class StudentEnum {
    // Enum for Gender
    public enum GenderType {
        MALE("m"),
        FEMALE("f"),
        OTHERS("o");
            
        private String gender;
        
        private GenderType(String gender) {
            this.gender = gender;
        }
        
        public String getGenderValue() {
            return this.gender;
        }
        
        // m to Male        
        public static String getGenderByString(String gender) {
            for (GenderType g : GenderType.values()) {
                if (g.gender.equals(gender)){
                    String key = g.name();
                    return key;
                }
            }
            return "Invalid gender";
        }
        
        // female to f
        public static String getGenderByValue(String gender) {
            for (GenderType g : GenderType.values()) {
                if (g.gender.equals(gender)) {
                    String val = g.getGenderValue();
                    return val;
                } else if (g.name().equals(gender)){
                    String val = g.getGenderValue();
                    return val;
                }
            }
            return "Invalid gender";
        }
    }
    
    // Enum for Blood Group
    public static enum BloodGroupType {
        A_POSITIVE("a+"),
        A_NEGATIVE("a-"),
        B_POSITIVE("b+"),
        B_NEGATIVE("b-"),
        O_POSITIVE("o+"),
        O_NEGATIVE("o-"),
        AB_POSITIVE("ab+"),
        AB_NEGATIVE("ab-");
        
        private String bloodGroup;
        
        private BloodGroupType(String bloodGroup) {
            this.bloodGroup = bloodGroup;
        }    
        
        public String getBloodGroupValue() {
            return this.bloodGroup;
        }
            
        // o+ to O_POSITIVE    
        public static String getBloodGroupByString(String bloodGroup) {
            for (BloodGroupType bg : BloodGroupType.values()) {
                if (bg.bloodGroup.equals(bloodGroup)) {
                    String key = bg.name();
                    return key;
                }
            }        
            return "Invalid bloodGroup";
        }   
        
        // O_POSITIVE to o+
        public static String getBloodGroupByValue(String bloodGroup) {
            for (BloodGroupType bg : BloodGroupType.values()) {
                if (bg.bloodGroup.equals(bloodGroup)) {
                    String val = bg.getBloodGroupValue();  
                    return val;
                } else if (bg.name().equals(bloodGroup)) {
                    String val = bg.getBloodGroupValue();
                    return val;
                }
            }        
            return "Invalid bloodGroup";
        }   
    }
}