package me.retrodaredevil.solarthing.solar.outback.fx.extra;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import me.retrodaredevil.solarthing.packets.identification.KnownSupplementaryIdentifier;
import me.retrodaredevil.solarthing.packets.identification.SupplementaryIdentifier;
import me.retrodaredevil.solarthing.solar.extra.SolarExtraPacketType;
import me.retrodaredevil.solarthing.solar.extra.SupplementarySolarExtraPacket;
import me.retrodaredevil.solarthing.solar.outback.OutbackIdentifier;
import me.retrodaredevil.solarthing.solar.outback.fx.common.FXDailyData;

import me.retrodaredevil.solarthing.annotations.NotNull;

@JsonDeserialize(as = ImmutableDailyFXPacket.class)
@JsonTypeName("FX_DAILY")
public interface DailyFXPacket extends FXDailyData, SupplementarySolarExtraPacket {

	@NotNull
    @Override
	default SolarExtraPacketType getPacketType() {
		return SolarExtraPacketType.FX_DAILY;
	}

	@Override
	@NotNull KnownSupplementaryIdentifier<OutbackIdentifier> getIdentifier();
}
