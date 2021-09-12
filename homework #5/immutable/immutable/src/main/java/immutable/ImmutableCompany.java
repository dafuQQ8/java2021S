/*
 *  Copyright (c) Monsters, Inc. All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by kagu-tsuchi <palerence@gmail.com>, September 2021
 */
package immutable;
/**
 * This's immutable class created for learning purposes.
 *
 * @version 1.0 10 Sep 2021
 * @author kagu-tsuchi
 */
public final class ImmutableCompany {
    /* goto test folder to test */
    private final String name;
    private final String industry;

    private ImmutableCompany(String name, String industry) {
        this.name = name;
        this.industry = industry;
    }

    public ImmutableCompany(String name) {
        this.name = name;
        this.industry = new String("To be picked ASAP.");
    }

    public ImmutableCompany newIndustry(String newIndustry) {
        return new ImmutableCompany(this.name, newIndustry);
    }
    /**
     * @return deep copy of company's industry.
     */
    public String currentIndustry() {
        return new String(this.industry);
    }
}
