
package acme.entities.assignment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.entities.leg.Leg;
import acme.realms.Member;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assignment extends AbstractEntity {

	// Serialisation version -------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------

	@Mandatory
	@Valid
	@Automapped
	private Role				role;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				lastUpdate;

	@Mandatory
	@Valid
	@Automapped
	private AssignmentStatus	status;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				remarks;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Leg					leg;

	@Optional
	@Valid
	@ManyToOne(optional = false)
	private Member				member;

}
