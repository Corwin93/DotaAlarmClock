package com.lance.dotaalarmclock.domain.repository;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import com.lance.dotaalarmclock.R;
import com.lance.dotaalarmclock.domain.model.entity.Artifact;
import com.lance.dotaalarmclock.domain.model.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10/29/2017.
 */

public class ArtifactRepository {
    private  List<Artifact> artifactList = new ArrayList<>();
    private  List<Item> itemList = new ArrayList<>();

    public ArtifactRepository() {
        fillArtifactVault();
        fillItemVault();
    }

    private  void fillArtifactVault() {
        artifactList.add(getSangeAndYasha());
        artifactList.add(getSange());
        artifactList.add(getYasha());
        artifactList.add(getOrchidMalevolence());
        artifactList.add(getOblivionStaff());
        artifactList.add(getCrystalys());
        artifactList.add(getBloodthorn());
        artifactList.add(getMagicWand());
        artifactList.add(getBracer());
        artifactList.add(getNullTalisman());
        artifactList.add(getWraithBand());
        artifactList.add(getSoulRing());
        artifactList.add(getPhaseBoots());
        artifactList.add(getPowerTreads());
        artifactList.add(getBootsOfTravel());
        artifactList.add(getHandOfMidas());
        artifactList.add(getPerseverance());
        artifactList.add(getMoonShard());
        artifactList.add(getRingOfBasilius());
        artifactList.add(getHeaddress());
        artifactList.add(getBuckler());
        artifactList.add(getUrnOfShadows());
        artifactList.add(getTranquilBoots());
        artifactList.add(getRingOfAquila());
        artifactList.add(getMedallionOfCourage());
        artifactList.add(getArcaneBoots());
        artifactList.add(getDrumOfEndurance());
        artifactList.add(getVladmirsOffering());
        artifactList.add(getMekansm());
        artifactList.add(getSpiritVessel());
        artifactList.add(getPipeOfInsight());
        artifactList.add(getGuardianGreaves());
        artifactList.add(getGlimmerCape());
        artifactList.add(getForceStaff());
        artifactList.add(getVeilOfDiscord());
        artifactList.add(getAetherLens());
        artifactList.add(getNecronomicon());
        artifactList.add(getSolarCrest());
        artifactList.add(getDagon());
        artifactList.add(getEulsScepterOfDivinity());
        artifactList.add(getRodOfAtos());
        artifactList.add(getAghanimsScepter());
        artifactList.add(getNullifier());
        artifactList.add(getRefresherOrb());
        artifactList.add(getScytheOfVyse());
        artifactList.add(getOctarineCore());
        artifactList.add(getHoodOfDefiance());
        artifactList.add(getVanguard());
        artifactList.add(getBladeMail());
        artifactList.add(getSoulBooster());
        artifactList.add(getCrimsonGuard());
        artifactList.add(getAeonDisk());
        artifactList.add(getBlackKingBar());
        artifactList.add(getLotusOrb());
        artifactList.add(getHurricanePike());
        artifactList.add(getShivasGuard());
        artifactList.add(getLinkensSphere());
        artifactList.add(getBloodstone());
        artifactList.add(getMantaStyle());
        artifactList.add(getHeartOfTarrasque());
        artifactList.add(getAssaultCuirass());
        artifactList.add(getArmletOfMordiggian());
        artifactList.add(getMeteorHammer());
        artifactList.add(getShadowBlade());
        artifactList.add(getSkullBasher());
        artifactList.add(getBattleFury());
        artifactList.add(getMonkeyKingBar());
        artifactList.add(getEtherealBlade());
        artifactList.add(getRadiance());
        artifactList.add(getDaedalus());
        artifactList.add(getButterfly());
        artifactList.add(getSilverEdge());
        artifactList.add(getDivineRapier());
        artifactList.add(getAbyssalBlade());
        artifactList.add(getDragonLance());
        artifactList.add(getKaya());
        artifactList.add(getMaskOfMadness());
        artifactList.add(getHelmOfTheDominator());
        artifactList.add(getEchoSabre());
        artifactList.add(getMaelstrom());
        artifactList.add(getDiffusalBlade());
        artifactList.add(getHeavensHalberd());
        artifactList.add(getDesolator());
        artifactList.add(getEyeOfSkadi());
        artifactList.add(getSatanic());
        artifactList.add(getMjollnir());
    }
    private  void fillItemVault() {
        itemList.add(getBladesOfAttack());
        itemList.add(getBroadsword());
        itemList.add(getBeltOfStrength());
        itemList.add(getOgreClub());
        itemList.add(getBladeOfAlacrity());
        itemList.add(getBandOfElvenskin());
        itemList.add(getRecipe());
        itemList.add(getQuarterStaff());
        itemList.add(getRobeOfTheMagi());
        itemList.add(getSagesMask());
        itemList.add(getEnchantedMango());
        itemList.add(getSentryWard());
        itemList.add(getObserverWard());
        itemList.add(getTomeOfKnowledge());
        itemList.add(getBottle());
        itemList.add(getIronBranch());
        itemList.add(getGauntletsOfStrength());
        itemList.add(getSlippersOfAgility());
        itemList.add(getMantleOfIntelligence());
        itemList.add(getCirclet());
        itemList.add(getStaffOfWizardry());
        itemList.add(getRingOfProtection());
        itemList.add(getQuellingBlade());
        itemList.add(getInfusedRaindrop());
        itemList.add(getStoutShield());
        itemList.add(getOrbOfVenom());
        itemList.add(getBlightStone());
        itemList.add(getChainmail());
        itemList.add(getHelmOfIronWill());
        itemList.add(getJavelin());
        itemList.add(getClaymore());
        itemList.add(getMithrilHammer());
        itemList.add(getMagicStick());
        itemList.add(getWindLace());
        itemList.add(getRingOfRegen());
        itemList.add(getBootsOfSpeed());
        itemList.add(getGlovesOfHaste());
        itemList.add(getCloak());
        itemList.add(getRingOfHealth());
        itemList.add(getGemOfTrueSight());
        itemList.add(getVoidStone());
        itemList.add(getMorbidMask());
        itemList.add(getShadowAmulet());
        itemList.add(getBlinkDagger());
        itemList.add(getGhostScepter());
        itemList.add(getEnergyBooster());
        itemList.add(getVitalityBooster());
        itemList.add(getPointBooster());
        itemList.add(getPlatemail());
        itemList.add(getTalismanOfEvasion());
        itemList.add(getHyperstone());
        itemList.add(getUltimateOrb());
        itemList.add(getDemonEdge());
        itemList.add(getMysticStaff());
        itemList.add(getReaver());
        itemList.add(getEaglesong());
        itemList.add(getSacredRelic());
    }

    public List<Artifact> getArtifactList() {
        return artifactList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    private  Artifact getYasha() {
        return Artifact.getBuilder().setName(R.string.yasha).setImageResourceId(R.drawable.ic_yasha)
                .addItem(getBladeOfAlacrity())
                .addItem(getBandOfElvenskin())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getSange() {
        return Artifact.getBuilder().setName(R.string.sange).setImageResourceId(R.drawable.ic_sange)
                .addItem(getOgreClub())
                .addItem(getBeltOfStrength())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getSangeAndYasha() {
        return Artifact.getBuilder().setName(R.string.sange_and_yasha).setImageResourceId(R.drawable.ic_sange_and_yasha)
                .addItem(getYasha())
                .addItem(getSange())
                .build();
    }
    private  Artifact getOrchidMalevolence() {
        return Artifact.getBuilder().setName(R.string.orchid_malevolence).setImageResourceId(R.drawable.ic_orchid_malevolence)
                .addItem(getOblivionStaff())
                .addItem(getOblivionStaff())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getOblivionStaff() {
        return Artifact.getBuilder().setName(R.string.oblivion_staff).setImageResourceId(R.drawable.ic_oblivion_staff)
                .addItem(getQuarterStaff())
                .addItem(getRobeOfTheMagi())
                .addItem(getSagesMask())
                .build();
    }
    private  Artifact getCrystalys() {
        return Artifact.getBuilder().setName(R.string.crystalys).setImageResourceId(R.drawable.ic_crystalys)
                .addItem(getBroadsword())
                .addItem(getBladesOfAttack())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getBloodthorn() {
        return Artifact.getBuilder().setName(R.string.bloodthorn).setImageResourceId(R.drawable.ic_bloodthorn)
                .addItem(getCrystalys())
                .addItem(getOrchidMalevolence())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getMagicWand() {
        return Artifact.getBuilder().setName(R.string.magic_wand).setImageResourceId(R.drawable.ic_magic_wand)
                .addItem(getMagicStick())
                .addItem(getIronBranch())
                .addItem(getIronBranch())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getBracer() {
        return Artifact.getBuilder().setName(R.string.bracer).setImageResourceId(R.drawable.ic_bracer)
                .addItem(getCirclet())
                .addItem(getGauntletsOfStrength())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getNullTalisman() {
        return Artifact.getBuilder().setName(R.string.null_talisman).setImageResourceId(R.drawable.ic_null_talisman)
                .addItem(getCirclet())
                .addItem(getMantleOfIntelligence())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getWraithBand() {
        return Artifact.getBuilder().setName(R.string.wraith_band).setImageResourceId(R.drawable.ic_wraith_band)
                .addItem(getCirclet())
                .addItem(getSlippersOfAgility())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getSoulRing() {
        return Artifact.getBuilder().setName(R.string.soul_ring).setImageResourceId(R.drawable.ic_soul_ring)
                .addItem(getRingOfRegen())
                .addItem(getGauntletsOfStrength())
                .addItem(getGauntletsOfStrength())
                .addItem(getRecipe())
                .build();
    }
    private  Artifact getPhaseBoots() {
        return Artifact.getBuilder().setName(R.string.phase_boots).setImageResourceId(R.drawable.ic_phase_boots)
                .addItem(getBootsOfSpeed())
                .addItem(getBladesOfAttack())
                .addItem(getBladesOfAttack())
                .build();
    }
    private  Artifact getPowerTreads() {
        return Artifact.getBuilder().setName(R.string.power_treads).setImageResourceId(R.drawable.ic_power_treads)
                .addItem(getBootsOfSpeed())
                .addItem(getGlovesOfHaste())
                .addItem(getBeltOfStrength())
                .build();
    }
    private  Artifact getPerseverance() {
        return Artifact.getBuilder().setName(R.string.perseverance).setImageResourceId(R.drawable.ic_perseverance)
                .addItem(getVoidStone())
                .addItem(getRingOfHealth())
                .build();
    }
    private  Artifact getHandOfMidas() {
        return Artifact.getBuilder().setName(R.string.hand_of_midas).setImageResourceId(R.drawable.ic_hand_of_midas)
                .addItem(getGlovesOfHaste())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getBootsOfTravel() {
        return Artifact.getBuilder().setName(R.string.boots_of_travel).setImageResourceId(R.drawable.ic_boots_of_travel)
                .addItem(getBootsOfSpeed())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getMoonShard() {
        return Artifact.getBuilder().setName(R.string.moon_shard).setImageResourceId(R.drawable.ic_moon_shard)
                .addItem(getHyperstone())
                .addItem(getHyperstone())
                .build();
    }

    private  Artifact getRingOfBasilius() {
        return Artifact.getBuilder().setName(R.string.ring_of_basilius).setImageResourceId(R.drawable.ic_ring_of_basilius)
                .addItem(getSagesMask())
                .addItem(getRingOfProtection())
                .build();
    }

    private  Artifact getHeaddress() {
        return Artifact.getBuilder().setName(R.string.headdress).setImageResourceId(R.drawable.ic_headdress)
                .addItem(getRingOfRegen())
                .addItem(getIronBranch())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getBuckler() {
        return Artifact.getBuilder().setName(R.string.buckler).setImageResourceId(R.drawable.ic_buckler)
                .addItem(getChainmail())
                .addItem(getIronBranch())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getUrnOfShadows() {
        return Artifact.getBuilder().setName(R.string.urn_of_shadows).setImageResourceId(R.drawable.ic_urn_of_shadows)
                .addItem(getInfusedRaindrop())
                .addItem(getCirclet())
                .addItem(getRingOfProtection())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getTranquilBoots() {
        return Artifact.getBuilder().setName(R.string.tranquil_boots).setImageResourceId(R.drawable.ic_tranquil_boots)
                .addItem(getBootsOfSpeed())
                .addItem(getWindLace())
                .addItem(getRingOfRegen())
                .build();
    }

    private  Artifact getRingOfAquila() {
        return Artifact.getBuilder().setName(R.string.ring_of_aquila).setImageResourceId(R.drawable.ic_ring_of_aquila)
                .addItem(getWraithBand())
                .addItem(getRingOfBasilius())
                .build();
    }

    private  Artifact getMedallionOfCourage() {
        return Artifact.getBuilder().setName(R.string.medallion_of_courage).setImageResourceId(R.drawable.ic_medallion_of_courage)
                .addItem(getChainmail())
                .addItem(getSagesMask())
                .addItem(getBlightStone())
                .build();
    }

    private  Artifact getArcaneBoots() {
        return Artifact.getBuilder().setName(R.string.arcane_boots).setImageResourceId(R.drawable.ic_arcane_boots)
                .addItem(getBootsOfSpeed())
                .addItem(getEnergyBooster())
                .build();
    }

    private  Artifact getDrumOfEndurance() {
        return Artifact.getBuilder().setName(R.string.drum_of_endurance).setImageResourceId(R.drawable.ic_drum_of_endurance)
                .addItem(getBracer())
                .addItem(getSagesMask())
                .addItem(getWindLace())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getVladmirsOffering() {
        return Artifact.getBuilder().setName(R.string.vladmirs_offering).setImageResourceId(R.drawable.ic_vladmirs_offering)
                .addItem(getMorbidMask())
                .addItem(getRingOfBasilius())
                .addItem(getHeaddress())
                .build();
    }

    private  Artifact getMekansm() {
        return Artifact.getBuilder().setName(R.string.mekansm).setImageResourceId(R.drawable.ic_mekansm)
                .addItem(getHeaddress())
                .addItem(getBuckler())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getSpiritVessel() {
        return Artifact.getBuilder().setName(R.string.spirit_vessel).setImageResourceId(R.drawable.ic_spirit_vessel)
                .addItem(getUrnOfShadows())
                .addItem(getPointBooster())
                .addItem(getWindLace())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getPipeOfInsight() {
        return Artifact.getBuilder().setName(R.string.pipe_of_insight).setImageResourceId(R.drawable.ic_pipe_of_insight)
                .addItem(getHoodOfDefiance())
                .addItem(getHeaddress())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getGuardianGreaves() {
        return Artifact.getBuilder().setName(R.string.guardian_greaves).setImageResourceId(R.drawable.ic_guardian_greaves)
                .addItem(getMekansm())
                .addItem(getArcaneBoots())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getGlimmerCape() {
        return Artifact.getBuilder().setName(R.string.glimmer_cape).setImageResourceId(R.drawable.ic_glimmer_cape)
                .addItem(getShadowAmulet())
                .addItem(getCloak())
                .build();
    }

    private  Artifact getForceStaff() {
        return Artifact.getBuilder().setName(R.string.force_staff).setImageResourceId(R.drawable.ic_force_staff)
                .addItem(getStaffOfWizardry())
                .addItem(getRingOfRegen())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getVeilOfDiscord() {
        return Artifact.getBuilder().setName(R.string.veil_of_discord).setImageResourceId(R.drawable.ic_veil_of_discord)
                .addItem(getHelmOfIronWill())
                .addItem(getNullTalisman())
                .addItem(getNullTalisman())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getAetherLens() {
        return Artifact.getBuilder().setName(R.string.aether_lens).setImageResourceId(R.drawable.ic_aether_lens)
                .addItem(getEnergyBooster())
                .addItem(getVoidStone())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getNecronomicon() {
        return Artifact.getBuilder().setName(R.string.necronomicon).setImageResourceId(R.drawable.ic_necronomicon)
                .addItem(getSagesMask())
                .addItem(getSagesMask())
                .addItem(getBeltOfStrength())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getSolarCrest() {
        return Artifact.getBuilder().setName(R.string.solar_crest).setImageResourceId(R.drawable.ic_solar_crest)
                .addItem(getMedallionOfCourage())
                .addItem(getTalismanOfEvasion())
                .build();
    }

    private  Artifact getDagon() {
        return Artifact.getBuilder().setName(R.string.dagon).setImageResourceId(R.drawable.ic_dagon)
                .addItem(getStaffOfWizardry())
                .addItem(getNullTalisman())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getEulsScepterOfDivinity() {
        return Artifact.getBuilder().setName(R.string.euls_scepter_of_divinity).setImageResourceId(R.drawable.ic_euls_scepter_of_divinity)
                .addItem(getStaffOfWizardry())
                .addItem(getWindLace())
                .addItem(getVoidStone())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getRodOfAtos() {
        return Artifact.getBuilder().setName(R.string.rod_of_atos).setImageResourceId(R.drawable.ic_rod_of_atos)
                .addItem(getStaffOfWizardry())
                .addItem(getBracer())
                .addItem(getBracer())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getAghanimsScepter() {
        return Artifact.getBuilder().setName(R.string.aghanims_scepter).setImageResourceId(R.drawable.ic_aghanims_scepter)
                .addItem(getPointBooster())
                .addItem(getStaffOfWizardry())
                .addItem(getBladeOfAlacrity())
                .addItem(getOgreClub())
                .build();
    }

    private  Artifact getNullifier() {
        return Artifact.getBuilder().setName(R.string.nullifier).setImageResourceId(R.drawable.ic_nullifier)
                .addItem(getHelmOfIronWill())
                .addItem(getSacredRelic())
                .build();
    }

    private  Artifact getRefresherOrb() {
        return Artifact.getBuilder().setName(R.string.refresher_orb).setImageResourceId(R.drawable.ic_refresher_orb)
                .addItem(getPerseverance())
                .addItem(getPerseverance())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getScytheOfVyse() {
        return Artifact.getBuilder().setName(R.string.scythe_of_vyse).setImageResourceId(R.drawable.ic_scythe_of_vyse)
                .addItem(getMysticStaff())
                .addItem(getUltimateOrb())
                .addItem(getVoidStone())
                .build();
    }

    private  Artifact getOctarineCore() {
        return Artifact.getBuilder().setName(R.string.octarine_core).setImageResourceId(R.drawable.ic_octarine_core)
                .addItem(getMysticStaff())
                .addItem(getSoulBooster())
                .build();
    }

    private  Artifact getHoodOfDefiance() {
        return Artifact.getBuilder().setName(R.string.hood_of_defiance).setImageResourceId(R.drawable.ic_hood_of_defiance)
                .addItem(getRingOfHealth())
                .addItem(getRingOfRegen())
                .addItem(getCloak())
                .build();
    }

    private  Artifact getVanguard() {
        return Artifact.getBuilder().setName(R.string.vanguard).setImageResourceId(R.drawable.ic_vanguard)
                .addItem(getRingOfHealth())
                .addItem(getVitalityBooster())
                .addItem(getStoutShield())
                .build();
    }

    private  Artifact getBladeMail() {
        return Artifact.getBuilder().setName(R.string.blade_mail).setImageResourceId(R.drawable.ic_blade_mail)
                .addItem(getBroadsword())
                .addItem(getChainmail())
                .addItem(getRobeOfTheMagi())
                .build();
    }

    private  Artifact getSoulBooster() {
        return Artifact.getBuilder().setName(R.string.soul_booster).setImageResourceId(R.drawable.ic_soul_booster)
                .addItem(getPointBooster())
                .addItem(getVitalityBooster())
                .addItem(getEnergyBooster())
                .build();
    }

    private  Artifact getCrimsonGuard() {
        return Artifact.getBuilder().setName(R.string.crimson_guard).setImageResourceId(R.drawable.ic_crimson_guard)
                .addItem(getVanguard())
                .addItem(getBuckler())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getAeonDisk() {
        return Artifact.getBuilder().setName(R.string.aeon_disk).setImageResourceId(R.drawable.ic_aeon_disk)
                .addItem(getVitalityBooster())
                .addItem(getEnergyBooster())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getBlackKingBar() {
        return Artifact.getBuilder().setName(R.string.black_king_bar).setImageResourceId(R.drawable.ic_black_king_bar)
                .addItem(getMithrilHammer())
                .addItem(getOgreClub())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getLotusOrb() {
        return Artifact.getBuilder().setName(R.string.lotus_orb).setImageResourceId(R.drawable.ic_lotus_orb)
                .addItem(getPerseverance())
                .addItem(getPlatemail())
                .addItem(getEnergyBooster())
                .build();
    }

    private  Artifact getHurricanePike() {
        return Artifact.getBuilder().setName(R.string.hurricane_pike).setImageResourceId(R.drawable.ic_hurricane_pike)
                .addItem(getForceStaff())
                .addItem(getDragonLance())
                .addItem(getWraithBand())
                .build();
    }

    private  Artifact getShivasGuard() {
        return Artifact.getBuilder().setName(R.string.shivas_guard).setImageResourceId(R.drawable.ic_shivas_guard)
                .addItem(getMysticStaff())
                .addItem(getPlatemail())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getLinkensSphere() {
        return Artifact.getBuilder().setName(R.string.linkens_sphere).setImageResourceId(R.drawable.ic_linkens_sphere)
                .addItem(getPerseverance())
                .addItem(getUltimateOrb())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getBloodstone() {
        return Artifact.getBuilder().setName(R.string.bloodstone).setImageResourceId(R.drawable.ic_bloodstone)
                .addItem(getSoulBooster())
                .addItem(getPerseverance())
                .build();
    }

    private  Artifact getMantaStyle() {
        return Artifact.getBuilder().setName(R.string.manta_style).setImageResourceId(R.drawable.ic_manta_style)
                .addItem(getUltimateOrb())
                .addItem(getYasha())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getHeartOfTarrasque() {
        return Artifact.getBuilder().setName(R.string.heart_of_tarrasque).setImageResourceId(R.drawable.ic_heart_of_tarrasque)
                .addItem(getReaver())
                .addItem(getVitalityBooster())
                .addItem(getVitalityBooster())
                .build();
    }

    private  Artifact getAssaultCuirass() {
        return Artifact.getBuilder().setName(R.string.assault_cuirass).setImageResourceId(R.drawable.ic_assault_cuirass)
                .addItem(getPlatemail())
                .addItem(getHyperstone())
                .addItem(getChainmail())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getArmletOfMordiggian() {
        return Artifact.getBuilder().setName(R.string.armlet_of_mordiggian).setImageResourceId(R.drawable.ic_armlet_of_mordiggian)
                .addItem(getHelmOfIronWill())
                .addItem(getGlovesOfHaste())
                .addItem(getBladesOfAttack())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getMeteorHammer() {
        return Artifact.getBuilder().setName(R.string.meteor_hammer).setImageResourceId(R.drawable.ic_meteor_hammer)
                .addItem(getOgreClub())
                .addItem(getStaffOfWizardry())
                .addItem(getRingOfRegen())
                .addItem(getSagesMask())
                .build();
    }

    private  Artifact getShadowBlade() {
        return Artifact.getBuilder().setName(R.string.shadow_blade).setImageResourceId(R.drawable.ic_shadow_blade)
                .addItem(getClaymore())
                .addItem(getShadowAmulet())
                .build();
    }

    private  Artifact getSkullBasher() {
        return Artifact.getBuilder().setName(R.string.skull_basher).setImageResourceId(R.drawable.ic_skull_basher)
                .addItem(getMithrilHammer())
                .addItem(getBeltOfStrength())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getBattleFury() {
        return Artifact.getBuilder().setName(R.string.battle_fury).setImageResourceId(R.drawable.ic_battle_fury)
                .addItem(getDemonEdge())
                .addItem(getPerseverance())
                .addItem(getQuellingBlade())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getMonkeyKingBar() {
        return Artifact.getBuilder().setName(R.string.monkey_king_bar).setImageResourceId(R.drawable.ic_monkey_king_bar)
                .addItem(getDemonEdge())
                .addItem(getJavelin())
                .addItem(getQuarterStaff())
                .build();
    }

    private  Artifact getEtherealBlade() {
        return Artifact.getBuilder().setName(R.string.ethereal_blade).setImageResourceId(R.drawable.ic_ethereal_blade)
                .addItem(getEaglesong())
                .addItem(getGhostScepter())
                .build();
    }

    private  Artifact getRadiance() {
        return Artifact.getBuilder().setName(R.string.radiance).setImageResourceId(R.drawable.ic_radiance)
                .addItem(getSacredRelic())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getDaedalus() {
        return Artifact.getBuilder().setName(R.string.daedalus).setImageResourceId(R.drawable.ic_daedalus)
                .addItem(getCrystalys())
                .addItem(getDemonEdge())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getButterfly() {
        return Artifact.getBuilder().setName(R.string.butterfly).setImageResourceId(R.drawable.ic_butterfly)
                .addItem(getEaglesong())
                .addItem(getTalismanOfEvasion())
                .addItem(getQuarterStaff())
                .build();
    }

    private  Artifact getSilverEdge() {
        return Artifact.getBuilder().setName(R.string.silver_edge).setImageResourceId(R.drawable.ic_silver_edge)
                .addItem(getShadowBlade())
                .addItem(getUltimateOrb())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getDivineRapier() {
        return Artifact.getBuilder().setName(R.string.divine_rapier).setImageResourceId(R.drawable.ic_divine_rapier)
                .addItem(getSacredRelic())
                .addItem(getDemonEdge())
                .build();
    }

    private  Artifact getAbyssalBlade() {
        return Artifact.getBuilder().setName(R.string.abyssal_blade).setImageResourceId(R.drawable.ic_abyssal_blade)
                .addItem(getVanguard())
                .addItem(getSkullBasher())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getDragonLance() {
        return Artifact.getBuilder().setName(R.string.dragon_lance).setImageResourceId(R.drawable.ic_dragon_lance)
                .addItem(getOgreClub())
                .addItem(getBandOfElvenskin())
                .addItem(getBandOfElvenskin())
                .build();
    }

    private  Artifact getKaya() {
        return Artifact.getBuilder().setName(R.string.kaya).setImageResourceId(R.drawable.ic_kaya)
                .addItem(getStaffOfWizardry())
                .addItem(getRobeOfTheMagi())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getMaskOfMadness() {
        return Artifact.getBuilder().setName(R.string.mask_of_madness).setImageResourceId(R.drawable.ic_mask_of_madness)
                .addItem(getMorbidMask())
                .addItem(getQuarterStaff())
                .build();
    }

    private  Artifact getHelmOfTheDominator() {
        return Artifact.getBuilder().setName(R.string.helm_of_the_dominator).setImageResourceId(R.drawable.ic_helm_of_the_dominator)
                .addItem(getGlovesOfHaste())
                .addItem(getHeaddress())
                .addItem(getRingOfHealth())
                .build();
    }

    private  Artifact getEchoSabre() {
        return Artifact.getBuilder().setName(R.string.echo_sabre).setImageResourceId(R.drawable.ic_echo_sabre)
                .addItem(getOgreClub())
                .addItem(getOblivionStaff())
                .build();
    }

    private  Artifact getMaelstrom() {
        return Artifact.getBuilder().setName(R.string.maelstrom).setImageResourceId(R.drawable.ic_maelstrom)
                .addItem(getMithrilHammer())
                .addItem(getJavelin())
                .build();
    }

    private  Artifact getDiffusalBlade() {
        return Artifact.getBuilder().setName(R.string.diffusal_blade).setImageResourceId(R.drawable.ic_diffusal_blade)
                .addItem(getBladeOfAlacrity())
                .addItem(getBladeOfAlacrity())
                .addItem(getRobeOfTheMagi())
                .addItem(getRecipe())
                .build();
    }

    private  Artifact getHeavensHalberd() {
        return Artifact.getBuilder().setName(R.string.heavens_halberd).setImageResourceId(R.drawable.ic_heavens_halberd)
                .addItem(getSange())
                .addItem(getTalismanOfEvasion())
                .build();
    }

    private  Artifact getDesolator() {
        return Artifact.getBuilder().setName(R.string.desolator).setImageResourceId(R.drawable.ic_desolator)
                .addItem(getMithrilHammer())
                .addItem(getMithrilHammer())
                .addItem(getBlightStone())
                .build();
    }

    private  Artifact getEyeOfSkadi() {
        return Artifact.getBuilder().setName(R.string.eye_of_skadi).setImageResourceId(R.drawable.ic_eye_of_skadi)
                .addItem(getUltimateOrb())
                .addItem(getUltimateOrb())
                .addItem(getPointBooster())
                .build();
    }

    private  Artifact getSatanic() {
        return Artifact.getBuilder().setName(R.string.satanic).setImageResourceId(R.drawable.ic_satanic)
                .addItem(getReaver())
                .addItem(getMorbidMask())
                .addItem(getClaymore())
                .build();
    }

    private  Artifact getMjollnir() {
        return Artifact.getBuilder().setName(R.string.mjollnir).setImageResourceId(R.drawable.ic_mjollnir)
                .addItem(getHyperstone())
                .addItem(getMaelstrom())
                .addItem(getRecipe())
                .build();
    }

    private  Item getBladesOfAttack() {
        @StringRes int name = R.string.blades_of_attack;
        		@DrawableRes int imageResourceId = R.drawable.ic_blades_of_attack;
        return new Item(name, imageResourceId);
    }

    private  Item getBroadsword() {
        @StringRes int name = R.string.broadsword;
		@DrawableRes int imageResourceId = R.drawable.ic_broadsword;
        return new Item(name, imageResourceId);
    }

    private  Item getBeltOfStrength() {
        @StringRes int name = R.string.belt_of_strength;
		@DrawableRes int imageResourceId = R.drawable.ic_belt_of_strength;
        return new Item(name, imageResourceId);
    }

    private  Item getOgreClub() {
        @StringRes int name = R.string.ogre_club;
		@DrawableRes int imageResourceId = R.drawable.ic_ogre_club;
        return new Item(name, imageResourceId);
    }

    private  Item getBladeOfAlacrity() {
        @StringRes int name = R.string.blade_of_alacrity;
		@DrawableRes int imageResourceId = R.drawable.ic_blade_of_alacrity;
        return new Item(name, imageResourceId);
    }

    private  Item getBandOfElvenskin() {
        @StringRes int name = R.string.band_of_elvenskin;
		@DrawableRes int imageResourceId = R.drawable.ic_band_of_elvenskin;
        return new Item(name, imageResourceId);
    }

    private  Item getRecipe() {
        @StringRes int name = R.string.recipe;
		@DrawableRes int imageResourceId = R.drawable.ic_recipe;
        return new Item(name, imageResourceId);
    }

    private  Item getQuarterStaff() {
        @StringRes int name = R.string.quarterstaff;
		@DrawableRes int imageResourceId = R.drawable.ic_quarterstaff;
        return new Item(name, imageResourceId);
    }

    private  Item getRobeOfTheMagi() {
        @StringRes int name = R.string.robe_of_the_magi;
		@DrawableRes int imageResourceId = R.drawable.ic_robe_of_the_magi;
        return new Item(name, imageResourceId);
    }

    private  Item getSagesMask() {
        @StringRes int name = R.string.sages_mask;
		@DrawableRes int imageResourceId = R.drawable.ic_sages_mask;
        return new Item(name, imageResourceId);
    }

    private  Item getEnchantedMango() {
        @StringRes int name = R.string.enchanted_mango;
		@DrawableRes int imageResourceId = R.drawable.ic_enchanted_mango;
        return new Item(name, imageResourceId);
    }

    private  Item getSentryWard() {
        @StringRes int name = R.string.sentry_ward;
		@DrawableRes int imageResourceId = R.drawable.ic_sentry_ward;
        return new Item(name, imageResourceId);
    }

    private  Item getObserverWard() {
        @StringRes int name = R.string.observer_ward;
		@DrawableRes int imageResourceId = R.drawable.ic_observer_ward;
        return new Item(name, imageResourceId);
    }

    private  Item getTomeOfKnowledge() {
        @StringRes int name = R.string.tome_of_knowledge;
		@DrawableRes int imageResourceId = R.drawable.ic_tome_of_knowledge;
        return new Item(name, imageResourceId);
    }

    private  Item getBottle() {
        @StringRes int name = R.string.bottle;
		@DrawableRes int imageResourceId = R.drawable.ic_bottle;
        return new Item(name, imageResourceId);
    }

    private  Item getIronBranch() {
        @StringRes int name = R.string.iron_branch;
		@DrawableRes int imageResourceId = R.drawable.ic_iron_branch;
        return new Item(name, imageResourceId);
    }

    private  Item getGauntletsOfStrength() {
        @StringRes int name = R.string.gauntlets_of_strength;
		@DrawableRes int imageResourceId = R.drawable.ic_gauntlets_of_strength;
        return new Item(name, imageResourceId);
    }

    private  Item getSlippersOfAgility() {
        @StringRes int name = R.string.slippers_of_agility;
		@DrawableRes int imageResourceId = R.drawable.ic_slippers_of_agility;
        return new Item(name, imageResourceId);
    }

    private  Item getMantleOfIntelligence() {
        @StringRes int name = R.string.mantle_of_intelligence;
		@DrawableRes int imageResourceId = R.drawable.ic_mantle_of_intelligence;
        return new Item(name, imageResourceId);
    }

    private  Item getCirclet() {
        @StringRes int name = R.string.circlet;
		@DrawableRes int imageResourceId = R.drawable.ic_circlet;
        return new Item(name, imageResourceId);
    }

    private  Item getStaffOfWizardry() {
        @StringRes int name = R.string.staff_of_wizardry;
		@DrawableRes int imageResourceId = R.drawable.ic_staff_of_wizardry;
        return new Item(name, imageResourceId);
    }

    private  Item getRingOfProtection() {
        @StringRes int name = R.string.ring_of_protection;
		@DrawableRes int imageResourceId = R.drawable.ic_ring_of_protection;
        return new Item(name, imageResourceId);
    }

    private  Item getQuellingBlade() {
        @StringRes int name = R.string.quelling_blade;
		@DrawableRes int imageResourceId = R.drawable.ic_quelling_blade;
        return new Item(name, imageResourceId);
    }

    private  Item getInfusedRaindrop() {
        @StringRes int name = R.string.infused_raindrop;
		@DrawableRes int imageResourceId = R.drawable.ic_infused_raindrop;
        return new Item(name, imageResourceId);
    }

    private  Item getStoutShield() {
        @StringRes int name = R.string.stout_shield;
		@DrawableRes int imageResourceId = R.drawable.ic_stout_shield;
        return new Item(name, imageResourceId);
    }

    private  Item getOrbOfVenom() {
        @StringRes int name = R.string.orb_of_venom;
		@DrawableRes int imageResourceId = R.drawable.ic_orb_of_venom;
        return new Item(name, imageResourceId);
    }

    private  Item getBlightStone() {
        @StringRes int name = R.string.blight_stone;
		@DrawableRes int imageResourceId = R.drawable.ic_blight_stone;
        return new Item(name, imageResourceId);
    }

    private  Item getChainmail() {
        @StringRes int name = R.string.chainmail;
		@DrawableRes int imageResourceId = R.drawable.ic_chainmail;
        return new Item(name, imageResourceId);
    }

    private  Item getHelmOfIronWill() {
        @StringRes int name = R.string.helm_of_iron_will;
		@DrawableRes int imageResourceId = R.drawable.ic_helm_of_iron_will;
        return new Item(name, imageResourceId);
    }

    private  Item getJavelin() {
        @StringRes int name = R.string.javelin;
		@DrawableRes int imageResourceId = R.drawable.ic_javelin;
        return new Item(name, imageResourceId);
    }

    private  Item getClaymore() {
        @StringRes int name = R.string.claymore;
		@DrawableRes int imageResourceId = R.drawable.ic_claymore;
        return new Item(name, imageResourceId);
    }

    private  Item getMithrilHammer() {
        @StringRes int name = R.string.mithril_hammer;
		@DrawableRes int imageResourceId = R.drawable.ic_mithril_hammer;
        return new Item(name, imageResourceId);
    }

    private  Item getMagicStick() {
        @StringRes int name = R.string.magic_stick;
		@DrawableRes int imageResourceId = R.drawable.ic_magic_stick;
        return new Item(name, imageResourceId);
    }

    private  Item getWindLace() {
        @StringRes int name = R.string.wind_lace;
		@DrawableRes int imageResourceId = R.drawable.ic_wind_lace;
        return new Item(name, imageResourceId);
    }

    private  Item getRingOfRegen() {
        @StringRes int name = R.string.ring_of_regen;
		@DrawableRes int imageResourceId = R.drawable.ic_ring_of_regen;
        return new Item(name, imageResourceId);
    }

    private  Item getBootsOfSpeed() {
        @StringRes int name = R.string.boots_of_speed;
		@DrawableRes int imageResourceId = R.drawable.ic_boots_of_speed;
        return new Item(name, imageResourceId);
    }

    private  Item getGlovesOfHaste() {
        @StringRes int name = R.string.gloves_of_haste;
		@DrawableRes int imageResourceId = R.drawable.ic_gloves_of_haste;
        return new Item(name, imageResourceId);
    }

    private  Item getCloak() {
        @StringRes int name = R.string.cloak;
		@DrawableRes int imageResourceId = R.drawable.ic_cloak;
        return new Item(name, imageResourceId);
    }

    private  Item getRingOfHealth() {
        @StringRes int name = R.string.ring_of_health;
		@DrawableRes int imageResourceId = R.drawable.ic_ring_of_health;
        return new Item(name, imageResourceId);
    }

    private  Item getGemOfTrueSight() {
        @StringRes int name = R.string.gem_of_true_sight;
		@DrawableRes int imageResourceId = R.drawable.ic_gem_of_true_sight;
        return new Item(name, imageResourceId);
    }

    private  Item getVoidStone() {
        @StringRes int name = R.string.void_stone;
		@DrawableRes int imageResourceId = R.drawable.ic_void_stone;
        return new Item(name, imageResourceId);
    }

    private  Item getMorbidMask() {
        @StringRes int name = R.string.morbid_mask;
		@DrawableRes int imageResourceId = R.drawable.ic_morbid_mask;
        return new Item(name, imageResourceId);
    }

    private  Item getShadowAmulet() {
        @StringRes int name = R.string.shadow_amulet;
		@DrawableRes int imageResourceId = R.drawable.ic_shadow_amulet;
        return new Item(name, imageResourceId);
    }

    private  Item getBlinkDagger() {
        @StringRes int name = R.string.blink_dagger;
		@DrawableRes int imageResourceId = R.drawable.ic_blink_dagger;
        return new Item(name, imageResourceId);
    }

    private  Item getGhostScepter() {
        @StringRes int name = R.string.ghost_scepter;
		@DrawableRes int imageResourceId = R.drawable.ic_ghost_scepter;
        return new Item(name, imageResourceId);
    }

    private  Item getEnergyBooster() {
        @StringRes int name = R.string.energy_booster;
		@DrawableRes int imageResourceId = R.drawable.ic_energy_booster;
        return new Item(name, imageResourceId);
    }

    private  Item getVitalityBooster() {
        @StringRes int name = R.string.vitality_booster;
		@DrawableRes int imageResourceId = R.drawable.ic_vitality_booster;
        return new Item(name, imageResourceId);
    }

    private  Item getPointBooster() {
        @StringRes int name = R.string.point_booster;
		@DrawableRes int imageResourceId = R.drawable.ic_point_booster;
        return new Item(name, imageResourceId);
    }

    private  Item getPlatemail() {
        @StringRes int name = R.string.platemail;
		@DrawableRes int imageResourceId = R.drawable.ic_platemail;
        return new Item(name, imageResourceId);
    }

    private  Item getTalismanOfEvasion() {
        @StringRes int name = R.string.talisman_of_evasion;
		@DrawableRes int imageResourceId = R.drawable.ic_talisman_of_evasion;
        return new Item(name, imageResourceId);
    }

    private  Item getHyperstone() {
        @StringRes int name = R.string.hyperstone;
		@DrawableRes int imageResourceId = R.drawable.ic_hyperstone;
        return new Item(name, imageResourceId);
    }

    private  Item getUltimateOrb() {
        @StringRes int name = R.string.ultimate_orb;
		@DrawableRes int imageResourceId = R.drawable.ic_ultimate_orb;
        return new Item(name, imageResourceId);
    }

    private  Item getDemonEdge() {
        @StringRes int name = R.string.demon_edge;
		@DrawableRes int imageResourceId = R.drawable.ic_demon_edge;
        return new Item(name, imageResourceId);
    }

    private  Item getMysticStaff() {
        @StringRes int name = R.string.mystic_staff;
		@DrawableRes int imageResourceId = R.drawable.ic_mystic_staff;
        return new Item(name, imageResourceId);
    }

    private  Item getReaver() {
        @StringRes int name = R.string.reaver;
		@DrawableRes int imageResourceId = R.drawable.ic_reaver;
        return new Item(name, imageResourceId);
    }

    private  Item getEaglesong() {
        @StringRes int name = R.string.eaglesong;
		@DrawableRes int imageResourceId = R.drawable.ic_eaglesong;
        return new Item(name, imageResourceId);
    }

    private  Item getSacredRelic() {
        @StringRes int name = R.string.sacred_relic;
		@DrawableRes int imageResourceId = R.drawable.ic_sacred_relic;
        return new Item(name, imageResourceId);
    }
}
