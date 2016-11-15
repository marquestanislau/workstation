<div class="tipoIngressos view">
<h2><?php echo __('Tipo Ingresso'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($tipoIngresso['TipoIngresso']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Designacao'); ?></dt>
		<dd>
			<?php echo h($tipoIngresso['TipoIngresso']['designacao']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Tipo Ingresso'), array('action' => 'edit', $tipoIngresso['TipoIngresso']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Tipo Ingresso'), array('action' => 'delete', $tipoIngresso['TipoIngresso']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $tipoIngresso['TipoIngresso']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Tipo Ingressos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Tipo Ingresso'), array('action' => 'add')); ?> </li>
	</ul>
</div>
