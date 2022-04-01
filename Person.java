package com.company;

import java.util.Scanner;

public class Person {
    Scanner sc = new Scanner(System.in);
    float height, weight, activity_factor; //activity factor is a multiplier that helps in calculation of calories burnt
    int age, activity;
    boolean lose = true;
    char sex;
    double calorie_intake_maintain, calorie_intake_mild_gain, calorie_intake_moderate_gain, calorie_intake_mild, calorie_intake_moderate, total_daily_energy_expenditure, basal_metabolic_rate, body_mass_index; // calories burnt in a day
    float cb_cycling, cb_walking, cb_swimming, cb_jogging; //cb = calories burnt during specific exercise

    public void setPerson()
    {
        System.out.print("\n\tEnter your height (in cms) : ");
        height = sc.nextFloat(); // getting height
        System.out.print("\tWeight (in kgs) : ");
        weight = sc.nextFloat(); // getting weight
        System.out.print("\tSex (M/F) : ");
        sex = sc.next().charAt(0); // charAt(0) gets zeroth index value
        while(sex != 'M' && sex != 'm' && sex != 'f' && sex != 'F')
        {
            System.out.println("\tInvalid input");
            System.out.print("\tEnter 'M' / 'm' / 'F' / 'f' : ");
            sex = sc.next().charAt(0);
        }
        System.out.print("\tAge : ");
        age = sc.nextByte(); // getting age
        System.out.print("""

                \tExercise: 15-30 minutes of elevated heart rate activity.
                \tIntense exercise: 45-120 minutes of elevated heart rate activity.
                \tVery intense exercise: 2+ hours of elevated heart rate activity.""");  // telling the user what Intense and Very Intense mean
        System.out.print("\n\n\t1. Sedentary" + // 1.2
                "\n\t2. Mild Activity(1-3 time a week)" + // 1.325
                "\n\t3. Moderate Activity(4-5 time a week)" + // 1.45
                "\n\t4. Active Activity(6-7 time a week)" + // 1.575
                "\n\t5. Intense Activity(6-7 intense workout days)" + // 1.7
                "\n\t6. Very Intense Activity(Intense daily activity)" + // 1.925
                "\n\tEnter choice : "); // getting their value
        activity = sc.nextByte();
        while(activity < 1 || activity > 6) // input validity
        {
            System.out.print("\tInput invalid" +
                    "\n\tEnter from 1 to 6 : ");
            activity = sc.nextByte();
        }
        switch (activity) {
            case 1 -> activity_factor = (float) 1.2;
            case 2 -> activity_factor = (float) 1.325;
            case 3 -> activity_factor = (float) 1.45;
            case 4 -> activity_factor = (float) 1.575;
            case 5 -> activity_factor = (float) 1.7;
            case 6 -> activity_factor = (float) 1.925; // assigning value for activity factor based on activity
        }
        System.out.print("\tGain or Lose (G/L) : ");
        char gol = sc.next().charAt(0);
        while(gol != 'G' && gol != 'g' && gol != 'L' && gol != 'l') // input validity
        {
            System.out.print("\tInput invalid" +
                    "\n\tEnter 'G' / 'g' / 'L' / 'l' : ");
            gol = sc.next().charAt(0);
        }
        if (gol == 'G' || gol == 'g')
            lose = false;
    }

    //BMR calculator
    public double setBasal_metabolic_rate() // function to calculate BMR
    {
        if(sex == 'm' || sex == 'M') // calculating BMR
            basal_metabolic_rate = 10 * weight + 6.25 * height - 5 * age + 5;
        else
            basal_metabolic_rate = 10 * weight + 6.25 * height - 5 * age - 161;
        return basal_metabolic_rate;
    }

    public void setTotal_daily_energy_expenditure() // function to calculate tdee which is the same as calories burnt
    {
        total_daily_energy_expenditure = setBasal_metabolic_rate() * activity_factor; // calculating tdee
        System.out.format("\n\tAverage Calorie Burnt per Day : %.2f cals\n", total_daily_energy_expenditure);
        //System.out.println(" calories");
    }

    public double setBody_mass_index()  // function to calculate body mass index
    {
        body_mass_index = (weight * 100 * 100) / (height * height); // calculating BMI
        return body_mass_index;
    }

    public void BMI_analytics() // analysing and printing BMI result
    {
        double bmi = setBody_mass_index();
        if(bmi < 16)
            System.out.format("\n\t%.2f - Severe Thinness\n", bmi);
        else if(bmi < 17)
            System.out.format("\n\t%.2f - Moderate Thinness\n", bmi);
        else if(bmi < 18.5)
            System.out.format("\n\t%.2f - Mild Thinness\n", bmi);
        else if(bmi < 25)
            System.out.format("\n\t%.2f - Normal\n", bmi);
        else if(bmi < 30)
            System.out.format("\n\t%.2f - Overweight\n", bmi);
        else if(bmi < 35)
            System.out.format("\n\t%.2f - Obese class I\n", bmi);
        else if(bmi < 40)
            System.out.format("\n\t%.2f - Obese class II\n", bmi);
        else
            System.out.format("\n\t%.2f - Obese class III\n", bmi);
    }
    public void setCb_cycling() // function to calculate calories spent while cycling
    {
        System.out.print("\n\tEnter duration (in hrs) : ");
        float duration = sc.nextFloat();
        cb_cycling = (float) (weight * 2.2 * 1.92 * 2 * duration);  //2.2 for lbs to kgs, 1.92 * 2 for calories used per hour
        System.out.format("\tEnergy Spent from cycling for %.1f hrs is : %.2f cals\n", duration, cb_cycling);
    }

    public void setCb_walking() // function to calculate calories spent while walking
    {
        System.out.print("\n\tEnter duration of walk(in hrs) : ");
        float duration = sc.nextFloat();
        cb_walking = (float) (weight * 2.2 * 1.72 * duration); // 2.2 for lbs to kgs, 1.72 for calories per hour
        System.out.format("\tEnergy Spent from walking for %.1f hrs is : %.2f cals\n", duration, cb_walking);
    }

    public void setCb_swimming() // function to calculate calories spent while swimming
    {
        System.out.print("\n\tEnter duration of swim(in hrs) : ");
        float duration = sc.nextFloat();
        cb_swimming = (float) (weight * 2.2 * 2.76 * duration); // 2.2 for lbs to kgs, 2.76 calories per hour
        System.out.format("\tEnergy Spent from swimming for %.1f hrs is : %.2f cals\n", duration, cb_swimming);
    }

    public void setCb_jogging() // function to calculate calories spent while jogging
    {
        System.out.print("\n\tEnter duration of jog(in hrs) : ");
        float duration = sc.nextFloat();
        cb_jogging = (float) (weight * 2.2 * 5.7 * duration); // 2.2 for kgs to pounds, 5.7 for calories per hour
        System.out.format("\tEnergy Spent from jogging for %.1f hrs is : %.2f cals\n", duration, cb_jogging);
    }

    public void setCalorie_intake() // function to calculating calorie intake for gaining or losing weight
    {
        setTotal_daily_energy_expenditure();
        calorie_intake_maintain = total_daily_energy_expenditure;
        if(lose) // calculating for losing weight
        {
            calorie_intake_mild = total_daily_energy_expenditure * 0.91; // 0.91 is the factor to reduce 0.25 kg per week
            calorie_intake_moderate = total_daily_energy_expenditure * 0.82; // 0.82 is the factor to reduce 0.5 kg per week
        }
        else  // calculating for gaining weight
        {
            calorie_intake_mild_gain = total_daily_energy_expenditure * 1.15; // 1.15 is the factor to increase 0.25 kg per week
            calorie_intake_moderate_gain = total_daily_energy_expenditure * 1.20; // 1.20 is the factor to increase 0.5 kg per week
        }
    }

    public void getCalorie_intake() // function to printing calorie intake for gaining or losing weight
    {
        System.out.format("\n\tFor maintaining weight    : %.2f cals\n", calorie_intake_maintain);
        if(lose) // printing for losing weight
        {
            System.out.format("\n\tFor mild weight loss     : %.2f (-9%%) cals\n" , calorie_intake_mild);
            System.out.format("\n\tFor moderate weight loss : %.2f (-18%%) cals\n" , calorie_intake_moderate);
        }
        else  // printing for gaining weight
        {
            System.out.format("\n\tFor mild weight gain     : %.2f (+15%%) cals\n" , calorie_intake_mild_gain);
            System.out.format("\n\tFor moderate weight gain : %.2f (+20%%) cals\n" , calorie_intake_moderate_gain);
        }
    }
}

class Body_Fat extends Person // Body fat class inherits class Person
{
    public double body_fat;

    public void setBody_fat() // function to calculate body fat
    {
        float neck_size, waist_size, hip_size;
        System.out.print("\n\tNeck (in cm) : ");
        neck_size = sc.nextFloat(); // getting neck size
        System.out.print("\tWaist (in cm) : ");
        waist_size = sc.nextFloat(); // getting waist size
        if (sex == 'm' || sex == 'M') // computing body fat for men
            body_fat = (495 / (1.0324 - 0.19077 * Math.log10(waist_size - neck_size) + 0.15456 * Math.log10(height))) - 450;
        else // computing body fat for women
        {
            System.out.print("\tHip (in cm) : ");
            hip_size = sc.nextFloat(); // getting hip size (only for women)
            body_fat = (495 / (1.29579 - 0.35004 * Math.log10(waist_size + hip_size - neck_size) + 0.22100 * Math.log10(height))) - 450;
        }
        System.out.format("\n\tBody fat %% : %.2f\n", body_fat); // printing body fat percentage
    }
}
